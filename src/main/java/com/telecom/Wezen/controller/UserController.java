package com.telecom.Wezen.controller;

import com.telecom.Wezen.entity.Users;
import com.telecom.Wezen.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get all users
    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        Users user = userService.getUserById(id);
        return (user != null) ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    // Create new user
    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return userService.saveUser(user);
    }

    // Update existing user
    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users updatedUser) {
        Users existing = userService.getUserById(id);
        if (existing != null) {
            updatedUser.setId(id);
            return ResponseEntity.ok(userService.saveUser(updatedUser));
        }
        return ResponseEntity.notFound().build();
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
