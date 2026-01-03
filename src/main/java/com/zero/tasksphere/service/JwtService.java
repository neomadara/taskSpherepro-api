package com.zero.tasksphere.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class JwtService {
    private final JwtEncoder jwtEncoder;
    private final JwtDecoder jwtDecoder;

    @Value("${jwt.expiration:86400000}")
    private Long expiration;

    public JwtService(JwtEncoder jwtEncoder, JwtDecoder jwtDecoder) {
        this.jwtEncoder = jwtEncoder;
        this.jwtDecoder = jwtDecoder;
    }

    public String generateToken(String username, Long userId) {
        Instant now = Instant.now();
        Instant expiresAt = now.plusMillis(expiration);

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("tasksphere")
                .issuedAt(now)
                .expiresAt(expiresAt)
                .subject(username)
                .claim("userId", userId)
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public Long extractUserId(String token) {
        return jwtDecoder.decode(token).getClaim("userId");
    }


}
