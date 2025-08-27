package com.telecom.Wezen.auth;

import com.telecom.Wezen.entity.Users;
import com.telecom.Wezen.jwt.JwtUtil;
import com.telecom.Wezen.records.Login;
import com.telecom.Wezen.records.Register;
import com.telecom.Wezen.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationController(UserRepository userRepository,
                                    JwtUtil jwtUtil,
                                    PasswordEncoder passwordEncoder,
                                    AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    // -------- REGISTER ----------
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Register request) {
        if (userRepository.findByMail(request.mail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already in use");
        }

        Users newUser = new Users();
        newUser.setName(request.name());
        newUser.setMail(request.mail());
        newUser.setPassword(passwordEncoder.encode(request.password()));
               // <-- important for security
          // <-- plan info

        userRepository.save(newUser);

        return ResponseEntity.ok(Map.of(
                "message", "User registered successfully",
                "id", newUser.getId(),
                "role", newUser.getRole(),
                "planId", newUser.getId()
        ));
    }

    // -------- LOGIN ----------
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.email(), request.password())
            );

            Users user = userRepository.findByMail(request.email())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Generate JWT containing role + planId
            String token = jwtUtil.generateToken(user.getMail(), user.getRole(), user.getId());

            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "message", "Login successful",
                    "userInfo", Map.of(
                            "userName", user.getName(),
                            "email", user.getMail(),
                            "role", user.getRole(),
                            "planId", user.getId()
                    )
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    // -------- VERIFY ----------
    @GetMapping("/verify")
    public ResponseEntity<?> verifyToken(@RequestHeader("Authorization") String token) {
        try {
            String jwt = token.replace("Bearer ", "");
            if (jwtUtil.validateToken(jwt)) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
