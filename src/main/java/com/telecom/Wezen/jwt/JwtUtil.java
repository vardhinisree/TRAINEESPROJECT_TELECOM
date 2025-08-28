package com.telecom.Wezen.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.telecom.Wezen.enums.Role;

import io.jsonwebtoken.*;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "sCq0pVC8136RdoVcTT36O0ueicmFfkkOrlRhklAtkBk="; // ⚠️ keep safe!

    // Generate JWT with role and planId
    public String generateToken(String email, Role role, Long uuid) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        claims.put("planId", uuid);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email) // subject = user email
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour expiry
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String extractRole(String token) {
        return extractClaim(token, claims -> claims.get("role", String.class));
    }

    public Long extractPlanId(String token) {
        return extractClaim(token, claims -> claims.get("planId", Long.class));
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

	
}
