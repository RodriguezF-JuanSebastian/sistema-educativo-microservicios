package com.edu.usuariosservice.seguridad;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretKey;

    private static final long EXPIRATION_TIME = 86400000; // 1 día en milisegundos

    // Método para generar el token JWT
    public String generarToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // Método para obtener el username desde el token
    public String obtenerUsernameDesdeToken(String token) {
        return obtenerClaimsDesdeToken(token).getSubject();  // 'getSubject' devuelve el nombre de usuario
    }

    // Método para obtener los claims desde el token
    private Claims obtenerClaimsDesdeToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    // Método para verificar si el token está expirado
    public boolean esTokenExpirado(String token) {
        return obtenerClaimsDesdeToken(token).getExpiration().before(new Date());
    }

    // Método para validar el token
    public boolean validarToken(String token, String username) {
        return (username.equals(obtenerUsernameDesdeToken(token)) && !esTokenExpirado(token));
    }
}
