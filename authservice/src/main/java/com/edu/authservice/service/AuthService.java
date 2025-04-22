/*
 * AuthService
 * Esta clase se encarga de manejar el proceso de autenticación. 
 * Aquí es donde validamos las credenciales del usuario (email y password), y si son correctas, generamos el token JWT
 */

 package com.edu.authservice.service;

 import com.edu.authservice.dto.UserCredentials;
 import com.edu.authservice.dto.UserDetailsDTO;
 import com.edu.authservice.security.JwtUtil;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 
 @Service
 public class AuthService {
 
     @Autowired
     private JwtUtil jwtUtil;
 
     // Simula un login, luego conectaremos con usuarios-service para validar usuario real
     public UserDetailsDTO login(UserCredentials credentials) {
         // Ejemplo simple: si el usuario es "admin" y contraseña "1234", autenticamos
         if ("admin@gmail.com".equals(credentials.getEmail()) && "1234".equals(credentials.getPassword())) {
             String token = jwtUtil.generateToken(credentials.getEmail());
 
             UserDetailsDTO user = new UserDetailsDTO();
             user.setEmail(credentials.getEmail());
             user.setToken(token);
             return user;
         }
 
         // Si no coincide, retornamos null (en el controlador manejaremos esto)
         return null;
     }
 }
 