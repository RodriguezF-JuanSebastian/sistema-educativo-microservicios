package com.edu.matriculasservice.servicios;

import com.edu.matriculasservice.entidades.Matricula;
import com.edu.matriculasservice.repositorios.MatriculaRepository;

import com.edu.matriculasservice.servicios.impl.MatriculaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MatriculaServiceTest {

    @Mock
    private MatriculaRepository matriculaRepository;

    @InjectMocks
    private MatriculaServiceImpl matriculaService; // Cambiado de MatriculaService a MatriculaServiceImpl


    @Test
    void testObtenerTodasLasMatriculas() {
        Matricula m1 = new Matricula(1L, 100L, 200L, LocalDate.now());
        Matricula m2 = new Matricula(2L, 101L, 201L, LocalDate.now());

        when(matriculaRepository.findAll()).thenReturn(Arrays.asList(m1, m2));

        List<Matricula> resultado = matriculaService.obtenerTodas();

        assertEquals(2, resultado.size());
        verify(matriculaRepository, times(1)).findAll();
    }

    @Test
    void testObtenerMatriculaPorId() {
        Matricula m = new Matricula(1L, 100L, 200L, LocalDate.now());

        when(matriculaRepository.findById(1L)).thenReturn(Optional.of(m));

        Optional<Matricula> resultado = matriculaService.obtenerPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals(100L, resultado.get().getUsuarioId());
        verify(matriculaRepository, times(1)).findById(1L);
    }

    @Test
    void testEliminarMatricula() {
        Long id = 1L;

        doNothing().when(matriculaRepository).deleteById(id);

        matriculaService.eliminar(id);

        verify(matriculaRepository, times(1)).deleteById(id);
    }
}