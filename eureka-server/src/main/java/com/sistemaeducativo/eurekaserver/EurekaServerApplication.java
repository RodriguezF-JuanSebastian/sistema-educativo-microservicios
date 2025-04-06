/*
 * Este es el codigo principal de un microservicio de Eureka Server en Spring Boot
 * que actua como un servidor de descubrimiento de servicios dentro de una arquitectura
 * de microservicios
 */
package com.sistemaeducativo.eurekaserver;
//Declara el paquete al que pertenece la clase, esta es una forma de organizar el codigo

import org.springframework.boot.SpringApplication;
/*
 * Importa la clase SpringApplication del framework de SpringBoot y se utiliza para lanzar aplicaciones
 * Spring Boot desde el metodo main
 */
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 * Importa la anotación @SpringBootApplication esta le dice a SpringBoot que es la clase principal 
 * @Configuration Permite definir beans de configuración
 * @EnableAutoConfiguration Activa la configuración automática de Spring Boot
 * @ComponentScan Escanea componentes, servicios y controladores en el paquete
 */
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/*
 * Importa la anotación @EnableEurekaServer, que es la clave que convierte esta aplicación en un servidor Eureka
 * y esto permite que los otros microservicios puedan registrarse en este servidor para descubrirse entre ellos
 */

@SpringBootApplication
//Anotación que indica que esta es una aplicación de SpringBoot y esta anotación siempre va en la clase principal
@EnableEurekaServer
/*
 * Anotación que habilita el modo servidor de Eureka, esto convierte la app en un registro central donde los 
 * microservicios pueden conectarse
 */
public class EurekaServerApplication { //Declara la clase principal de la aplicación llamada EurekaServerApplication

	public static void main(String[] args) {
	//Metodo principal de java, es el punto de entrada de la aplicación cuando se ejecuta
	//Aquí arranca cuando se realiza el mvn spring-boot:run
		SpringApplication.run(EurekaServerApplication.class, args);
		/*
		 * Ejecuta tu aplicación Spring Boot, Crea el contexto de Spring, inicia el servidor web embebido (Tomcat)
		 * Y aplica las configuraciones
		 */
	}

}
