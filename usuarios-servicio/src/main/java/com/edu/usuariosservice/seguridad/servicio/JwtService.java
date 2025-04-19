package com.edu.usuariosservice.seguridad.servicio;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET_KEY = "mi_clave_secreta"; // Debes cambiarla por una clave secreta más segura

    // Método para generar el JWT
    public String generarToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hora de validez
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Método para extraer el username del JWT
    public String extraerUsername(String token) {
        return extraerClaim(token, Claims::getSubject);
    }

    // Método para extraer información de las claims del JWT
    private <T> T extraerClaim(String token, ClaimsResolver<T> claimsResolver) {
        final Claims claims = extraerClaims(token);
        return claimsResolver.resolve(claims);
    }

    // Método para extraer las claims del JWT
    private Claims extraerClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    // Método para verificar si el token es válido
    public boolean tokenEsValido(String token, UserDetails userDetails) {
        final String username = extraerUsername(token);
        return (username.equals(userDetails.getUsername()) && !esTokenExpirado(token));
    }

    // Método para verificar si el token ha expirado
    private boolean esTokenExpirado(String token) {
        return extraerClaims(token).getExpiration().before(new Date());
    }

    // Interfaz funcional para resolver las claims
    @FunctionalInterface
    public interface ClaimsResolver<T> {
        T resolve(Claims claims);
    }
}