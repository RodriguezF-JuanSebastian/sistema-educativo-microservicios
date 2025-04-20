package com.edu.asignaturas_servicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Clase principal del microservicio asignaturas-service.
 * Es el punto de entrada de la aplicación Spring Boot.
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.edu.asignaturas_servicio.repository")
@EntityScan(basePackages = "com.edu.asignaturas_servicio.model")
public class AsignaturasServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsignaturasServiceApplication.class, args);
	}
}