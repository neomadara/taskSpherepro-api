package com.zero.tasksphere.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class JwtService {
    private final JwtEncoder jwtEncoder;

    @Value("${jwt.expiration:86400000}")
    private Long expiration;

    public JwtService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    public String generateToken(String username) {
        Instant now = Instant.now();
        Instant expiresAt = now.plusMillis(expiration);

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("tasksphere")
                .issuedAt(now)
                .expiresAt(expiresAt)
                .subject(username)
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }


}
