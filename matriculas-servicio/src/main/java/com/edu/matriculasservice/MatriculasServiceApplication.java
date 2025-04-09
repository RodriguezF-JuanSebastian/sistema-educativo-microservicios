package com.edu.matriculasservice;
// Define el paquete en el que se encuentra esta clase
// El nombre del paquete refleja la estructura del proyecto y la ubicación del microservicio

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Importa las clases necesarias de Spring Boot para ejecutar la aplicación
// SpringApplication: clase que lanza la aplicación Spring Boot
// SpringBootApplication: anotación que marca esta clase como punto de entrada del microservicio
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
// Esta anotación combina tres funcionalidades esenciales
// @Configuration: indica que la clase puede contener definiciones de beans
// @EnableAutoConfiguration: habilita la configuración automática de Spring Boot
// @ComponentScan: permite a Spring escanear el paquete y sus subpaquetes en busca de componentes, servicios y controladores
@EnableFeignClients // Habilita el uso de Feign Clients

public class MatriculasServiceApplication {
// Clase principal del microservicio matriculas-service
// El nombre de la clase suele reflejar el nombre del microservicio
// Contiene el método `main` que actúa como punto de entrada a la aplicación

	public static void main(String[] args) {
		SpringApplication.run(MatriculasServiceApplication.class, args);
		// Lanza la aplicación Spring Boot.
		// Este método inicializa el contexto de Spring y ejecuta el microservicio
	}

}
