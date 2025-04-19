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

package com.edu.usuariosservice; //Linea que indica a que paquete pertenece la clase

//Estas dos lineas importan las clases se Spring Boot que se necesitan para iniciar la aplicación
import org.springframework.boot.SpringApplication; //Clase que se necesita para inicar la aplicación Spring Boot
//Anotación que le dice a Spring Boot que esta clase es la clase principal y debe inicializar todo automaticamente
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories; 

/*
 * Anotación que le dice a Spring Boot que esta es la clase principal del proyecto
 * Internamente es una combinación de
 * @Configuration: le dice a Spring que esta clase puede contener beans
 * @EnableAutoConfiguration: le dice a Spring Boot que configure la aplicación automáticamente
 * @ComponentScan: le dice a Spring que escanee este paquete y subpaquetes en busca de componentes (@Controller, @Service)
*/

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.edu.usuariosservice.repositorios")
@EntityScan(basePackages = "com.edu.usuariosservice.modelos")
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
