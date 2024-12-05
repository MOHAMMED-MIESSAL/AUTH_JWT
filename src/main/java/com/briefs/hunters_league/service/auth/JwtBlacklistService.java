package com.briefs.hunters_league.service.auth;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtBlacklistService {

    // Liste noire pour stocker les tokens invalidés
    private final Set<String> blacklistedTokens = new HashSet<>();

    // Ajoute un token à la liste noire
    public void blacklistToken(String token) {
        blacklistedTokens.add(token);
    }

    // Vérifie si un token est dans la liste noire
    public boolean isTokenBlacklisted(String token) {
        return blacklistedTokens.contains(token);
    }
}
