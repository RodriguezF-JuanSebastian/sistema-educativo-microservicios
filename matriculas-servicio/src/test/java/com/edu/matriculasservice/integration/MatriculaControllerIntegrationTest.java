package com.edu.matriculasservice.integration;

import com.edu.matriculasservice.MatriculasServicioApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;

@SpringBootTest(
        classes = MatriculasServicioApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureWebTestClient
@ActiveProfiles("test") // Usa un perfil "test" si tienes un application-test.yml
class MatriculaControllerIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @LocalServerPort
    private int port;


    @Test
    void obtenerMatriculaConDetalles_deberiaRetornarDatosCorrectos() {
        webTestClient.get()
                .uri("/api/matriculas/{id}", 1) // Usa el ID de la matrícula que estás probando
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.nombreUsuario").isNotEmpty() // Verifica que 'nombreUsuario' no esté vacío
                .jsonPath("$.nombreUsuario").isEqualTo("Juan Pérez"); // Verifica que el valor sea "Juan Pérez"
    }


}
