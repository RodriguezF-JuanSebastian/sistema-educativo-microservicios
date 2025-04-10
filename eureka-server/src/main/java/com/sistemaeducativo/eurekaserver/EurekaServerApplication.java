/*
 * MICRO SERVIDOR EUREKA - SPRING CLOUD
 * Esta clase representa el punto de entrada del microservicio Eureka Server.
 * Su función principal es actuar como **servidor de descubrimiento**, permitiendo
 * que otros microservicios dentro del sistema se **registren y descubran** entre ellos.
 * 
 * FUNCIONALIDADES CLAVE:
 * Se configura automáticamente como aplicación Spring Boot gracias a @SpringBootApplication.
 * Se habilita como **servidor Eureka** mediante la anotación @EnableEurekaServer.
 * Permite que clientes Eureka (otros microservicios) se conecten, se registren y busquen servicios.
 * 
 * EJECUCIÓN:
 * Al correr esta clase, se levanta un servidor web embebido (por defecto en el puerto 8761)
 * que expone una interfaz visual en http://localhost:8761 para ver los servicios registrados.
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
