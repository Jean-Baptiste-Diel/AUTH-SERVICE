package com.apkMoney.apkMoney.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class JwtUtil {
    private final String SECRET_KEY = "maCleSecrete123"; // À sécuriser !

    public String generateToken(String numero, String prenom) {
        return Jwts.builder()
                .setSubject(numero)
                .claim("prenom", prenom)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1h
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

