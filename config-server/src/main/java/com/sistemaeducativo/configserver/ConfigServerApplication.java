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
