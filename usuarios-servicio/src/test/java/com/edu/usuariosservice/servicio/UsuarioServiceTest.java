package com.edu.usuariosservice.servicio;

import com.edu.usuariosservice.servicios.UsuarioService;
import com.edu.usuariosservice.modelos.Usuario;
import com.edu.usuariosservice.repositorios.UsuarioRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void testObtenerTodosLosUsuarios() {
        Usuario u1 = new Usuario(1L, "Juan", "juan@mail.com", "1234", "ROLE_USER");
        Usuario u2 = new Usuario(2L, "Ana", "ana@mail.com", "abcd", "ROLE_ADMIN");

        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(u1, u2));

        List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();

        assertEquals(2, usuarios.size());
        assertEquals("Juan", usuarios.get(0).getNombre());
    }

    @Test
    void testObtenerUsuarioPorId() {
        Usuario usuario = new Usuario(1L, "Carlos", "carlos@mail.com", "pass", "ROLE_USER");

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        Optional<Usuario> resultado = usuarioService.obtenerUsuarioPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Carlos", resultado.get().getNombre());
    }
}
