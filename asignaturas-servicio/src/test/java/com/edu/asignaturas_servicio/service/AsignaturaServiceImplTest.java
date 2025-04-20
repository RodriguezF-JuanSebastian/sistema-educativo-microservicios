package com.edu.asignaturas_servicio.service;

import com.edu.asignaturas_servicio.entity.Asignatura;
import com.edu.asignaturas_servicio.repository.AsignaturaRepository;
import com.edu.asignaturas_servicio.service.impl.AsignaturaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Habilita Mockito para JUnit 5
public class AsignaturaServiceImplTest {

    @Mock
    private AsignaturaRepository asignaturaRepository;

    @InjectMocks
    private AsignaturaServiceImpl asignaturaService;

    private Asignatura asignatura;

    @BeforeEach
    void setUp() {
        // Datos de prueba comunes
        asignatura = new Asignatura();
        asignatura.setId(1L);
        asignatura.setNombre("Matemáticas");
    }

    @Test
    void testObtenerTodas() {
        // Configurar mock
        when(asignaturaRepository.findAll()).thenReturn(Arrays.asList(asignatura));

        // Ejecutar método
        List<Asignatura> resultado = asignaturaService.obtenerTodas();

        // Verificar
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(asignaturaRepository, times(1)).findAll();
    }

    @Test
    void testObtenerPorId() {
        // Configurar mock
        when(asignaturaRepository.findById(1L)).thenReturn(Optional.of(asignatura));

        // Ejecutar método
        Optional<Asignatura> resultado = asignaturaService.obtenerPorId(1L);

        // Verificar
        assertTrue(resultado.isPresent());
        assertEquals("Matemáticas", resultado.get().getNombre());
        verify(asignaturaRepository, times(1)).findById(1L);
    }

    @Test
    void testGuardar() {
        // Configurar mock
        when(asignaturaRepository.save(any(Asignatura.class))).thenReturn(asignatura);

        // Ejecutar método
        Asignatura resultado = asignaturaService.guardar(asignatura);

        // Verificar
        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        verify(asignaturaRepository, times(1)).save(asignatura);
    }

    @Test
    void testEliminar() {
        // No necesitamos configurar when() porque deleteById es void

        // Ejecutar método
        asignaturaService.eliminar(1L);

        // Verificar
        verify(asignaturaRepository, times(1)).deleteById(1L);
    }

    @Test
    void testActualizarExitoso() {
        // Configurar mock
        when(asignaturaRepository.findById(1L)).thenReturn(Optional.of(asignatura));
        when(asignaturaRepository.save(any(Asignatura.class))).thenReturn(asignatura);

        // Ejecutar método
        Asignatura resultado = asignaturaService.actualizar(asignatura);

        // Verificar
        assertNotNull(resultado);
        verify(asignaturaRepository, times(1)).findById(1L);
        verify(asignaturaRepository, times(1)).save(asignatura);
    }

    @Test
    void testActualizarNoEncontrado() {
        // Configurar mock para simular que no existe
        when(asignaturaRepository.findById(1L)).thenReturn(Optional.empty());

        // Ejecutar y verificar excepción
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            asignaturaService.actualizar(asignatura);
        });

        assertEquals("Asignatura no encontrada con ID: 1", exception.getMessage());
        verify(asignaturaRepository, times(1)).findById(1L);
        verify(asignaturaRepository, never()).save(any());
    }
}