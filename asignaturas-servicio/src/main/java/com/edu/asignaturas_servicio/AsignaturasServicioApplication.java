/*
 * Clase principal del microservicio "asignaturas-servicio".
 * Esta clase sirve como punto de entrada para iniciar la aplicación Spring Boot.
 * Al ejecutarse, configura automáticamente el entorno del microservicio,
 * inicializa el contexto de Spring, escanea componentes y levanta el servidor embebido.
 */

//Declara el paquete al que pertenece esta clase, organizando el codigo y evitando conflictos
//Paquete que contine el microservicio de asiagnaturas
package com.edu.asignaturas_servicio;

//Estas dos lineas importan las lienas necesarias para Spring Boot
import org.springframework.boot.SpringApplication; //Esta clase permite iniciar una aplicación Spring Boot
/*
 * Esta es una anotación que convina tres cosas 
 * @Configuration: Marca la clase como una clase de configuración.
 * @EnableAutoConfiguration: Le dice a Spring Boot que configure automáticamente tu aplicación.
 * @ComponentScan: Le indica a Spring que busque otros componentes, servicios y configuraciones dentro 
 * del paquete y los registre.
 */
import org.springframework.boot.autoconfigure.SpringBootApplication; 

//Esta notación marca la clase como punto de entrada 
/*
 * Le permite a Spring Boot Escanear el paquete com.edu.asignaturas_servicio y subpaquetes para buscar 
 * clases anotadas con @Component, @Service, @Repository, @Controller y cargar configuraciones automáticamente
 */
@SpringBootApplication
public class AsignaturasServicioApplication { //Aquí se declara la clase principal porque es la que tiene el metodo main
	//Declara el metodo principal en java, este es el metodo que se ejecuta al iniciar la aplicación
	public static void main(String[] args) { 
		//Esta linea lo que hace es llamar a SpringApplication.run para iniciar microservicio Spring Boot
		//Crea el contexto de la aplicación Spring Boot, inicia el servidor embebido realiza configuración automatica
		//Escanea los componentes y los registra
		SpringApplication.run(AsignaturasServicioApplication.class, args);
	}
}

