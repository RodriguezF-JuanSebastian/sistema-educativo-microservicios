/*
 * USUARIOS-SERVICE - MICROSERVICIO DE GESTIÓN DE USUARIOS
 * 
 * Esta clase representa la **clase principal** del microservicio `usuarios-service` en una 
 * arquitectura distribuida basada en Spring Boot y Spring Cloud. 
 * 
 * FUNCIONALIDAD PRINCIPAL:
 * 
 * Inicia el contexto de Spring Boot para este microservicio.
 * Registra automáticamente todos los componentes anotados (@Controller, @Service, @Repository, etc.)
 * dentro del paquete `com.edu.usuariosservice` y sus subpaquetes.
 * Marca esta aplicación como una aplicación Spring Boot lista para ejecutarse de forma embebida.
 * 
 * ANOTACIONES CLAVE:
 * @SpringBootApplication → Esta anotación combina:
 * - @Configuration: permite definir beans de configuración.
 * - @EnableAutoConfiguration: configura automáticamente beans según las dependencias del classpath.
 * - @ComponentScan: busca componentes dentro del paquete para registrarlos en el contexto.
 * 
 * CONTEXTO DE USO:
 * - Este microservicio es responsable de gestionar la lógica de negocio y persistencia
 * relacionada con usuarios del sistema educativo (por ejemplo, estudiantes y docentes).
 * - Generalmente se conecta a una base de datos (MySQL) y puede ser consumido por otros
 * microservicios (por ejemplo, `matriculas-service`) a través de Feign Client.
 * 
 * EJECUCIÓN:
 * - Al ejecutar esta clase, se levanta un servidor web embebido (como Tomcat) y el microservicio
 * queda disponible para recibir peticiones HTTP en sus controladores.
 */

// 🔹 Paquete principal del microservicio
package com.edu.usuariosservice;

// 🔹 Imports de Spring Boot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 🔹 JPA y Escaneo de entidades/repositorios
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 🔧 Clase principal del microservicio usuarios-service
 * Contiene el método main() que inicia la aplicación.
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.edu.usuariosservice.repository") // Repositorios JPA
@EntityScan(basePackages = "com.edu.usuariosservice.model") // Entidades JPA
public class UsuariosServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsuariosServiceApplication.class, args); // 🚀 Punto de arranque
    }
}
