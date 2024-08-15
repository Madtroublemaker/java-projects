package org.example.expensetracker.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.expensetracker.dto.TokenUser;
import org.example.expensetracker.response.AuthResponse;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class TokenService {

    private String SECRET_KEY = "KASYAVASYA";
    long expiration = 1000 * 60 * 60 * 48;

    public String generateToken(TokenUser user) {
        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put("id", user.getId());
        claims.put("role", user.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes(StandardCharsets.UTF_8))
                .compact();
    }

    public AuthResponse authResponseFromToken(String token) {
        return new AuthResponse(token);
    }

    public TokenUser verifyToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token).getBody();
            return TokenUser.builder()
                    .id(claims.get("id", Long.class))
                    .username(claims.getSubject())
                    .role(claims.get("role", String.class))
                    .build();
        } catch (Exception e) {
            return null;
        }
    }
}
