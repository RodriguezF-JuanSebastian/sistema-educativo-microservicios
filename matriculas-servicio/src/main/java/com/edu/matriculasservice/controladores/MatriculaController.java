/*
 * Controlador REST del microservicio `matriculas-service`.
 * 
 * Esta clase expone un endpoint HTTP para consultar datos de un usuario
 * desde el microservicio de usuarios, utilizando el servicio `MatriculaService`.
 * 
 * Anotaciones clave:
 * - @RestController: indica que esta clase es un controlador REST que devuelve datos en formato JSON.
 * - @RequestMapping("/matriculas"): define la ruta base del controlador.
 * 
 * Funcionalidad principal:
 * - Permite obtener información de un usuario matriculado mediante una solicitud GET
 * al endpoint `/matriculas/usuario/{id}`.
 */

//Define que esta clase esta dentro del paquete controladores
package com.edu.matriculasservice.controladores;

//Importa clases necesarias del proyecto
import com.edu.matriculasservice.clientes.MatriculaUsuarioDTO; //Objeto que contiene los datos del usuario retornados
//Clase que contiene la logica del negocio para comunicarse con el micro servicio de usuarios
import com.edu.matriculasservice.servicios.MatriculaService; 
//importa anotaciones de Spring para controladores 
import org.springframework.beans.factory.annotation.Autowired; //para realizar inyecciones en el servicio
//Anotaciones para construir endpoints REST @RestController, @RequestMapping, @GetMapping, @PathVariable
import org.springframework.web.bind.annotation.*; 

@RestController //Indica que esta clase es un controlador REST, todos los metodos devolveran datos en formato JSON
//Establece la ruta base del controlador, todos los endpoints definidos aquí comenzaran con /matriculas
@RequestMapping("/matriculas") 
public class MatriculaController {

    //Inyección del servicio MatriculaService que contiene la logica del negocio para consultar información
    //del usuario desde otro microservicio
    @Autowired 
    private MatriculaService matriculaService;

    //Define un endpoint GET que responde a la url /matriculas/usuario/{id}
    //@PathVariable Long id Inidica que el valor {id} de la URL se pasa como parametro al metodo
    //matriculaService.obtenerDatosUsuario(id) Llamar al servicio para obtener los datos del usuario y los 
    //retorna como respuesta
    @GetMapping("/usuario/{id}")
    public MatriculaUsuarioDTO obtenerUsuario(@PathVariable Long id) {
        return matriculaService.obtenerDatosUsuario(id);
    }
}
