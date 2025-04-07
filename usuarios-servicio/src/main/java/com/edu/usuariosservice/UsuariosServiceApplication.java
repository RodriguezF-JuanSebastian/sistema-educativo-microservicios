package com.edu.usuariosservice; //Line que indica a que paquete pertenece la clase

//Estas dos lineas importan las clases se Spring Boot que se necesitan para iniciar la aplicación
import org.springframework.boot.SpringApplication; //Clase que se necesita para inicar la aplicación Spring Boot
//Anotación que le dice a Spring Boot que esta clase es la clase principal y debe inicializar todo automaticamente
import org.springframework.boot.autoconfigure.SpringBootApplication; 

/*
 * Anotación que le dice a Spring Boot que esta es la clase principal del proyecto
 * Internamente es una combinación de
 * @Configuration: le dice a Spring que esta clase puede contener beans
 * @EnableAutoConfiguration: le dice a Spring Boot que configure la aplicación automáticamente
 * @ComponentScan: le dice a Spring que escanee este paquete y subpaquetes en busca de componentes (@Controller, @Service)
*/

@SpringBootApplication
public class UsuariosServiceApplication { //Se declara la clase principal del microservicio

	/*
	 * Spring Boot siempre necesita una clase que contenga el main
	 * Este es el punto de entrada de cualquier aplicación Java
	 * Cuando se ejecuta la app empieza desde aquí
	 */
	public static void main(String[] args) {  
		//Este metodo arranca el contexto de Spring Boot y pone en marcha toda la aplicación
		//Recibe como argumento la clase principal y los argumentos que lleguen por consola (arsg)
		SpringApplication.run(UsuariosServiceApplication.class, args);
	}

}
