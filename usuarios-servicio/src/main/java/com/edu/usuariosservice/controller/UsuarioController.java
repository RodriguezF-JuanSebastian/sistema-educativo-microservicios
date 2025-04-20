/*
 * UsuarioController.java
 * Este controlador maneja las operaciones HTTP relacionadas con la entidad Usuario.
 * Expone una API REST con endpoints para listar, buscar, crear y eliminar usuarios.
 * Se comunica con el servicio UsuarioService para realizar las operaciones necesarias sobre la base de datos.
 * 
 * Endpoints:
 * - GET /usuarios           → Listar todos los usuarios
 * - GET /usuarios/{id}      → Buscar un usuario por su ID
 * - POST /usuarios          → Crear un nuevo usuario
 * - DELETE /usuarios/{id}   → Eliminar un usuario por su ID
 */

 //Define el paquete al que pertenece la clase en este caso forma parte de la capa de controladores del microservicio 
 package com.edu.usuariosservice.controller;

 import com.edu.usuariosservice.model.Usuario;
 import com.edu.usuariosservice.service.UsuarioService;
 
 import jakarta.validation.Valid;
 
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.*;
 import org.springframework.web.bind.annotation.*;
 //import org.springframework.security.core.annotation.AuthenticationPrincipal;
 //import org.springframework.security.core.userdetails.UserDetails;
 
 import java.util.*;
 
 @RestController
 @RequestMapping("/usuarios")

 public class UsuarioController {
 
     @Autowired
     private UsuarioService usuarioService;
 
     @GetMapping
     public ResponseEntity<List<Usuario>> obtenerTodos() {
         return ResponseEntity.ok(usuarioService.obtenerTodosLosUsuarios());
     }
 
     @GetMapping("/{id}")
     public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id){
         Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorId(id);
         return usuario.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
     }
 
     @PostMapping
     public ResponseEntity<Usuario> guardarUsuario(@Valid @RequestBody Usuario usuario) {
         Usuario nuevo = usuarioService.guardarUsuario(usuario);
         return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
     }
 
     @DeleteMapping("/{id}")
     public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
         usuarioService.eliminarUsuario(id);
         return ResponseEntity.noContent().build();
     }
 
     @PutMapping("/{id}")
     public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @Valid @RequestBody Usuario usuarioActualizado){
         try {
             Usuario actualizado = usuarioService.actualizarUsuario(id, usuarioActualizado);
             return ResponseEntity.ok(actualizado);
         } catch (Exception e) {
             return ResponseEntity.notFound().build();
         }
     }
 
     @GetMapping("/rol/{rol}")
     public ResponseEntity<List<Usuario>> obtenerUsuariosPorTipoUsuario(@PathVariable String rol){
         return ResponseEntity.ok(usuarioService.obtenerUsuariosPorTipoUsuario(rol));
     }
     /*
     @GetMapping("/usuario-auth")
     public ResponseEntity<String> getUsuarioAutenticado(@AuthenticationPrincipal UserDetails userDetails) {
         return ResponseEntity.ok("Usuario autenticado: " + userDetails.getUsername());
     } 
     
     @PutMapping("/actualizar-password/{id}")
     public ResponseEntity<String> actualizarPassword(@PathVariable Long id, @RequestBody CambioPasswordRequest request) {
         try {
             usuarioService.actualizarPassword(id, request.getNuevaPassword());
             return ResponseEntity.ok("Password actualizado exitosamente");
         } catch (Exception e) {
             return ResponseEntity.status(400).body("Error al actualizar el password: " + e.getMessage());
         }
    }*/
 }

