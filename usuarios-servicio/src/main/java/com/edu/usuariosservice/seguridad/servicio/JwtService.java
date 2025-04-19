package com.edu.usuariosservice.seguridad.servicio;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET_KEY = "74657374656173696e6f6d61736c6c617665636c617665"; // esta es la clave codificada en HEX o BASE64

    // Método auxiliar para obtener la clave segura
    private Key obtenerClaveFirma() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

// Generar JWT con roles
public String generarToken(String username, String roles) {
    return Jwts.builder()
            .setSubject(username)
            .claim("roles", roles) // <-- Aquí se agregan los roles
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
            .signWith(obtenerClaveFirma(), SignatureAlgorithm.HS256)
            .compact();
}

    // Extraer username
    public String extraerUsername(String token) {
        return extraerClaim(token, Claims::getSubject);
    }

    // Extraer un claim
    private <T> T extraerClaim(String token, ClaimsResolver<T> claimsResolver) {
        final Claims claims = extraerClaims(token);
        return claimsResolver.resolve(claims);
    }

    // Extraer todos los claims usando parserBuilder
    private Claims extraerClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(obtenerClaveFirma())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Validar token
    public boolean tokenEsValido(String token, UserDetails userDetails) {
        final String username = extraerUsername(token);
        return (username.equals(userDetails.getUsername()) && !esTokenExpirado(token));
    }

    // Verificar expiración
    private boolean esTokenExpirado(String token) {
        return extraerClaims(token).getExpiration().before(new Date());
    }

    // Interfaz funcional
    @FunctionalInterface
    public interface ClaimsResolver<T> {
        T resolve(Claims claims);
    }

    // Extraer roles desde el token
    public String extraerRoles(String token) {
        return extraerClaims(token).get("roles", String.class);
    }
}