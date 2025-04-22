package com.edu.authservice.security;

/*
 * JwtUtil
 * Esta clase se encarga de generar, validar y obtener información desde el token JWT
 */

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    // Clave secreta para firmar el token (nunca debe ir en texto plano en producción)
    private final String SECRET_KEY = "mi_clave_secreta_super_segura";

    // Tiempo de expiración del token en milisegundos (ej: 1 hora)
    private final long EXPIRATION_TIME = 3600000;

    // Genera el token JWT usando el email del usuario como subject
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email) // el contenido principal del token
                .setIssuedAt(new Date()) // fecha de emisión
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // expiración
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY) // firma con algoritmo y clave secreta
                .compact();
    }

    // Extrae el email (subject) desde el token
    public String extractEmail(String token) {
        return getClaims(token).getSubject();
    }

    // Verifica si el token es válido (no expirado y con firma correcta)
    public boolean isTokenValid(String token) {
        try {
            Claims claims = getClaims(token);
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    // Obtiene todos los claims del token (payload)
    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
