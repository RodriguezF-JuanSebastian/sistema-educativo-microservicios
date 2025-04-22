package com.edu.matriculasservice.integration;

import com.edu.matriculasservice.MatriculasServicioApplication;
import com.edu.matriculasservice.entidades.Matricula;
import com.edu.matriculasservice.repositorios.MatriculaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import java.time.LocalDate;

@SpringBootTest(
        classes = MatriculasServicioApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureWebTestClient
@ActiveProfiles("test")
class MatriculaControllerIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private MatriculaRepository matriculaRepository; // Asegúrate de tener este repositorio

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        // Limpia datos existentes
        matriculaRepository.deleteAll();

        // Crea una matrícula de prueba SIN especificar el ID
        Matricula matricula = new Matricula();
        matricula.setUsuarioId(1L);
        matricula.setAsignaturaId(1L);
        matricula.setNombreUsuario("Juan Pérez");
        matricula.setNombreAsignatura("Matemáticas");
        matricula.setDescripcionAsignatura("Curso de matemáticas básicas");
        matricula.setFecha(LocalDate.now());

        // Guarda y recupera la matrícula
        Matricula savedMatricula = matriculaRepository.save(matricula);

        // Guarda el ID generado para usarlo en el test
        matriculaId = savedMatricula.getId();
    }

    private Long matriculaId; // Variable para almacenar el ID generado

    @Test
    void obtenerMatriculaConDetalles_deberiaRetornarDatosCorrectos() {
        webTestClient.get()
                .uri("/api/matriculas/{id}", matriculaId)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.nombreUsuario").isNotEmpty()
                .jsonPath("$.nombreUsuario").isEqualTo("Juan Pérez");
    }
}