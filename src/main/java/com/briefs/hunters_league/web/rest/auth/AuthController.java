package com.briefs.hunters_league.web.rest.auth;

import com.briefs.hunters_league.utils.request.LoginRequest;
import com.briefs.hunters_league.service.auth.JwtBlacklistService;
import com.briefs.hunters_league.service.auth.JwtService;
import com.briefs.hunters_league.service.auth.MyDatabaseUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final MyDatabaseUserDetailsService userDetailsService;
    private final JwtBlacklistService jwtBlacklistService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
            UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
            String jwt = jwtService.generateToken(userDetails);
            return ResponseEntity.status(200).body("Login successful: " + jwt);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String authHeader) {
        // Extraire le token du header Authorization
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            // Ajoute le token à la liste noire
            jwtBlacklistService.blacklistToken(token);

            return ResponseEntity.ok("Logout successful");
        }

        return ResponseEntity.badRequest().body("Authorization header is missing or invalid");
    }
}
