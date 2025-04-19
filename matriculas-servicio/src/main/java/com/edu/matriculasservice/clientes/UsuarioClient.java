/*
 * Interface Feign Client que permite al microservicio `matriculas-service` comunicarse
 * con el microservicio `usuarios-service`.
 * 
 * Anotaciones clave:
 * - @FeignClient: define el nombre del microservicio destino registrado en Eureka.
 * - @GetMapping: mapea la ruta del endpoint del microservicio destino.
 * 
 * Funcionalidad principal:
 * - Permite consumir el endpoint `/usuarios/{id}` del microservicio `usuarios-service`
 * para obtener los datos de un usuario por su ID.
 * 
 * Con esta interfaz, el microservicio matriculas-service puede invocar directamente endpoints del
 * microservicio usuarios-service como si fuera una llamada local, gracias a Feign y Eureka
 */

 //Define que esta clase pertenece al paquete clientes 
package com.edu.matriculasservice.clientes;

//Importa anotaciones necesarias 
import org.springframework.cloud.openfeign.FeignClient; //Para declarar un cliente Feign
import org.springframework.web.bind.annotation.GetMapping; //Para definir el endpoint remoto y sus parametros
import org.springframework.web.bind.annotation.PathVariable; //Para definir el endpoint remoto y sus parametros

//ESta anotación declara que esta interfaz sera un cliente Feign que se conecta al microservicio
//registrado como usuarios-service en eureka server
//Spring se encargara de generar automaticamente la implementación de esta interfaz al iniciar la aplicación 
@FeignClient(name = "usuarios-service")
//DEclara la interfaz del cliente Feign contendra metodos que representen llamadas HTTP al microservicio remoto 
//usuarios-service
public interface UsuarioClient {

    //Este metodo mapea una llamada GET a la URL /usuarios/{id} del microservicio de usuarios
    //Vincula el parametro de metodo id con el valor en la URL
    //Devuelve un objeto MatriculaUsuarioDTO que contine los datos del usuario recuperados
    @GetMapping("/usuarios/{id}")
    MatriculaUsuarioDTO obtenerUsuarioPorId(@PathVariable("id") Long id);
}