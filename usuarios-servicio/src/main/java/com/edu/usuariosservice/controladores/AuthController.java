package com.edu.usuariosservice.controladores;

import com.edu.usuariosservice.modelos.AuthResponse;
import com.edu.usuariosservice.modelos.LoginRequest;
import com.edu.usuariosservice.seguridad.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        if ("admin".equals(request.getUsername()) && "1234".equals(request.getPassword())) {
            String token = jwtUtil.generarToken(request.getUsername());
            System.out.println("Token generado: " + token); // Verificar token generado
            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }

}

