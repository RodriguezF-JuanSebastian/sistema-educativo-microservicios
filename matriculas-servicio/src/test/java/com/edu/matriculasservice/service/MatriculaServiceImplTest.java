package com.edu.matriculasservice.service;

import com.edu.matriculasservice.model.Usuario;
import com.edu.matriculasservice.client.UsuarioFeignClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class MatriculaServiceImplTest {

    @InjectMocks
    private MatriculaServiceImpl matriculaService;

    @Mock
    private UsuarioFeignClient usuarioFeignClient;  // Mock del Feign Client

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void registrarMatriculaTest() {
        // Prepara el usuario mock
        Usuario usuarioMock = new Usuario();
        usuarioMock.setId(1L);
        usuarioMock.setNombre("Juan Pérez");
        usuarioMock.setEmail("juan.perez@example.com");
        usuarioMock.setTipoUsuario("Estudiante");

        // Configura el comportamiento del Feign Client mock
        when(usuarioFeignClient.obtenerUsuarioPorId(1L)).thenReturn(usuarioMock);

        // Llama al método que quieres probar
        matriculaService.registrarMatricula(1L);

        // Verifica que el Feign Client haya sido llamado correctamente
        verify(usuarioFeignClient).obtenerUsuarioPorId(1L);

        // También puedes verificar otras interacciones, como asegurarte de que se haya realizado algún cambio en el estado
        // o que un repositorio haya sido llamado, dependiendo de lo que estés probando.
    }
}
