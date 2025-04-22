/*
 * AuthController
 * Este controlador expone el endpoint público que permite a los usuarios hacer login. 
 * Recibe el email y contraseña, y si son correctos, devuelve un token JWT
 * 
 * Qué hace esto
 * Recibe un POST /auth/login con email y password
 * Llama al servicio para autenticar
 * Si está bien, responde con un 200 OK y el token
 * Si está mal, responde con 401 Unauthorized
 */

 package com.edu.authservice.controller;

 import com.edu.authservice.dto.UserCredentials;
 import com.edu.authservice.dto.UserDetailsDTO;
 import com.edu.authservice.service.AuthService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;
 
 import jakarta.validation.Valid;
 
 @RestController
 @RequestMapping("/auth")
 public class AuthController {
 
     @Autowired
     private AuthService authService;
 
     @PostMapping("/login")
     public ResponseEntity<?> login(@Valid @RequestBody UserCredentials credentials) {
         UserDetailsDTO user = authService.login(credentials);
 
         if (user == null) {
             return ResponseEntity.status(401).body("Credenciales inválidas");
         }
 
         return ResponseEntity.ok(user);
     }
 }