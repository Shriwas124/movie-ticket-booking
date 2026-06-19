package com.example.mtb.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
@Component
public class JwtService {

    private String secret;

    public String createJwtToken(TokenPayload tokenPayload) {
        return Jwts.builder()
                .setClaims(tokenPayload.Claims())
                .setSubject(tokenPayload.Subject())
                .setIssuedAt(new Date(tokenPayload.IssuedAt().toEpochMilli()))
                .setExpiration(new Date(tokenPayload.Expiration().toEpochMilli()))
                .signWith(getSignatureKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignatureKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode("QBUBq6XFdxajsYhPfdHHo/VJtXbgvrQvevm9ZcmyPHo="));
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}

