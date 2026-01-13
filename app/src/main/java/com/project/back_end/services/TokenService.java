package com.project.back_end.services;

import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TokenService {

    // A simple map to store tokens and associated usernames
    private final ConcurrentHashMap<String, String> tokenRepo = new ConcurrentHashMap<>();

    // Generates a random token for a user
    public String generateToken(String username) {
        String token = UUID.randomUUID().toString();
        tokenRepo.put(token, username);
        return token;
    }

    // Validates if a token exists
    public boolean validateToken(String token) {
        return tokenRepo.containsKey(token);
    }

    // Gets the username associated with a token
    public String getUsernameFromToken(String token) {
        return tokenRepo.get(token);
    }

    // Removes token upon logout
    public void invalidateToken(String token) {
        tokenRepo.remove(token);
    }
}