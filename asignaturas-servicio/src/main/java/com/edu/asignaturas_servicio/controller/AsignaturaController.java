/*
 * Controlador REST para el microservicio de asignaturas.
 * Expone una API REST que permite realizar operaciones CRUD básicas
 * sobre las asignaturas: listar, buscar por ID, guardar y eliminar.
 * 
 * Utiliza las anotaciones de Spring Web (@RestController, @RequestMapping, etc.)
 * para mapear las rutas y manejar peticiones HTTP como GET, POST y DELETE.
 * 
 * Las operaciones son delegadas al servicio AsignaturaService.
 * 
 * Este controlador es el puente entre el cliente y la lógica del negocio, es decir, permite que desde Postman,
 * o una app web se puedan hacer peticiones para manipular asignaturas en la base de datos.
 */


//Declara el paquete de donde se encuentra este controlador
package com.edu.asignaturas_servicio.controller;

//Importa la clase entidad Asignatura y la interfaz de servicio AsignaturaService que se utilizara para la logica
//del negocio
import com.edu.asignaturas_servicio.entity.Asignatura;
import com.edu.asignaturas_servicio.service.AsignaturaService;
//Importa anotaciones de Spring necesarias para inyección de dependencias y para definir controladores REST
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Importa clases utilitarias para manejar listas y valores opcionales posiblmente nulos
import java.util.List;
import java.util.Optional;

@RestController //Anotación que indica que esta clase es un controlador REST que devuelve objetos JSON en las respuestas HTTP
@RequestMapping("/api/asignaturas") //Define que todas las rutas del controlador comenzaran con /api/asignaturas
public class AsignaturaController {

    @Autowired //Inyecta automaticamente una instancia de AsignaturaService para poder usar sus metodos
    // Es el componente que contiene la logica para manejar asignaturas obtener, guardar, eliminar
    private AsignaturaService asignaturaService; 

    @GetMapping //Maneja solicitudes HTTP Get en /api/asignaturas
    public List<Asignatura> obtenerTodas() { //Devuelve una lista de todas las asignaturas
        return asignaturaService.obtenerTodas();
    }

    @GetMapping("/{id}") //Maneja solicitudes GET con un parametro {id}
    //@PathVariable Extrae el valor id desde la URL
    //@PathVariable Devuelve la asignatura correspondiente al ID si existe o un valor vacio si no
    public Optional<Asignatura> obtenerPorId(@PathVariable Long id) { 
        return asignaturaService.obtenerPorId(id); 
    }

    @PostMapping //Maneja solicitudes POST para crear una nueva asignatura
    //@RequestBody Indica que el cuerpo de la solicitud en formato JSON se convertira en un objeto Asignatura
    //guardar() Llama al servicio para guardar la asignatura
    public Asignatura guardar(@RequestBody Asignatura asignatura) {
        return asignaturaService.guardar(asignatura);
    }

    @DeleteMapping("/{id}") //Maneja solicitudes DELETE con un parametro {id}
    public void eliminar(@PathVariable Long id) { //Llama al servicio para eliminar la asignatura con ese ID
        asignaturaService.eliminar(id);
    }
}
