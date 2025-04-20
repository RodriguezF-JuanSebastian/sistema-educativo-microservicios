/*
 * CONFIG SERVER - SPRING CLOUD
 * Esta clase representa el punto de entrada del microservicio de **servidor de configuración** 
 * (Config Server) en una arquitectura de microservicios con Spring Cloud.
 * 
 * FUNCIONALIDAD PRINCIPAL:
 * Actúa como servidor centralizado de configuración para todos los microservicios del sistema.
 * Expone configuraciones externas desde un repositorio Git (o sistema de archivos local) 
 * en formato `.yml` o `.properties`.
 * Permite que los microservicios clientes (usuarios-service, matriculas-service, etc.)
 * obtengan sus configuraciones dinámicamente desde este servidor.
 * 
 * ANOTACIONES CLAVE:
 * @SpringBootApplication → Marca la clase como una aplicación Spring Boot.
 * @EnableConfigServer → Habilita el modo servidor de configuración (Spring Cloud Config).
 * @EnableDiscoveryClient → Permite que este servidor se registre en Eureka (para ser localizado 
 * automáticamente por otros servicios sin hardcodear su URL).
 * 
 * EJECUCIÓN:
 * - Al ejecutar esta clase, se levanta un servidor Spring Boot (por defecto en el puerto 8888)
 * que sirve los archivos de configuración solicitados por los clientes registrados.
 */

//Define el paquete al que pertenece esta clase
package com.sistemaeducativo.configserver;

//Importar las clases necesarias para que Spring Boot pueda arrancar
import org.springframework.boot.SpringApplication;
//SpringBootApplication es una anotación que habilita varias cosas de forma automática
import org.springframework.boot.autoconfigure.SpringBootApplication;
//Permite que esta aplicación se registre como cliente en un servidor Eureka
//Es util para que otros microservicios puedan encontrar el config-server y consumir sus configuraciones
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//Habilita este microservicio como servidor de configuración centralizada
//Sirve archivos de configuración (applictation.properties, yml) que pueden esta en un respositorio git o local
import org.springframework.cloud.config.server.EnableConfigServer;

//Anotación de convivencia que convina 3 cosas 
//@Configuration: Permite definir beans.
//@EnableAutoConfiguration: Configura automáticamente la app.
//@ComponentScan: Escanea componentes dentro del paquete.
@SpringBootApplication
//Convierte esta aplicación en un servidor de configuaración Spring Cloud
//expone enpoints para que otros microservicios puedan leer sus configuraciones externas desde git u otra fuente
@EnableConfigServer
//Indica que este servidor de configuración puede resgistrarse en Eureka para que los clientes lo encuentren
//automaticamente sin hardcordear su url
@EnableDiscoveryClient

//Esta es la clase principal del proyecto, es la que se ejecuta al levantar el microservicio
public class ConfigServerApplication {

	//Este es le punto de entrada de la aplicación
	public static void main(String[] args) {
		//Inicia toda la infraestructura de Spring Boot cargando el contexto de Spring
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}

