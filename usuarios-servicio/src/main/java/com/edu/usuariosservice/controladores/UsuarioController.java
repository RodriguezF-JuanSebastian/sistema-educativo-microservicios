package com.edu.usuariosservice.controladores;

import com.edu.usuariosservice.modelos.Usuario;
import com.edu.usuariosservice.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // GET - Listar todos los usuarios
    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerTodosLosUsuarios();
    }

    // GET - Buscar usuario por ID
    @GetMapping("/{id}")
    public Optional<Usuario> obtenerPorId(@PathVariable Long id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    // POST - Crear nuevo usuario
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    // DELETE - Eliminar usuario por ID
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
    }
}