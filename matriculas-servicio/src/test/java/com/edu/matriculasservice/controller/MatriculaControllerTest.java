package com.edu.matriculasservice.controller;

import com.edu.matriculasservice.model.Matricula;
import com.edu.matriculasservice.service.MatriculaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MatriculaControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private MatriculaController matriculaController;

    @Mock
    private MatriculaService matriculaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(matriculaController).build();
    }

    @Test
    public void registrarMatriculaTest() throws Exception {
        // Prepara el mock para registrar una matrícula (no es necesario "stubbing" con when() para métodos void)
        Matricula matriculaMock = new Matricula();
        matriculaMock.setId(1L);

        // Realiza la solicitud HTTP POST simulada y verifica la respuesta
        mockMvc.perform(post("/matriculas/registrar/1"))
               .andExpect(status().isOk())  // Verifica que el status HTTP sea 200 (OK)
               .andExpect(jsonPath("$.id").value(1L));  // Verifica que la respuesta tenga el id correcto

        // Verifica que el método registrarMatricula haya sido llamado correctamente
        verify(matriculaService, times(1)).registrarMatricula(1L);
    }
}