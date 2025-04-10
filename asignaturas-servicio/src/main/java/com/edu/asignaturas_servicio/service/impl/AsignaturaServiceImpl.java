/*
 * Implementación de la interfaz AsignaturaService para el microservicio "asignaturas-servicio".
 * Esta clase contiene la lógica de negocio para manejar las operaciones CRUD relacionadas
 * con las asignaturas, usando el repositorio AsignaturaRepository para interactuar con la base de datos.
 * Está anotada con @Service, lo que permite que Spring la detecte como un componente de servicio
 * y la administre como un bean para la inyección de dependencias.
 * Métodos implementados:
 * - obtenerTodas(): obtiene todas las asignaturas desde la base de datos.
 * - obtenerPorId(Long id): busca una asignatura por su ID.
 * - guardar(Asignatura asignatura): guarda o actualiza una asignatura.
 * - eliminar(Long id): elimina una asignatura por su ID.
 */

 //Define en donde esta ubicado el paquete impl, indicando que es una implementación concreta de una interfaz de servicio
package com.edu.asignaturas_servicio.service.impl;


//Importa las clases necesarias del proyecto
import com.edu.asignaturas_servicio.entity.Asignatura; //Entidad que representa una asignatura
import com.edu.asignaturas_servicio.repository.AsignaturaRepository; //Interfaz que maneja la comuniación con la db
import com.edu.asignaturas_servicio.service.AsignaturaService; //Interfaz que esta clase implementara
import org.springframework.beans.factory.annotation.Autowired; //Se usa para la inyección automatica de dependencias
//Marca la clase como un componente de servicio permitiendo que Spring la detecte y registre como un bean
import org.springframework.stereotype.Service;

//Importa clases de la Api de Java para manejar 
import java.util.List; //Lista de objetos
import java.util.Optional; //Objetos que pueden o no contener un valor y evita errores null

@Service //Indica que esta clase es un servicio gestionado por Spring
//Aquí esta el nombre de la clase AsignaturaServiceImpl
//implements AsignaturaService, esta implementando los metodos definidos en la interfaz AsignaturaService
public class AsignaturaServiceImpl implements AsignaturaService { 

    @Autowired //Anotación de Spring que inyecta automaticamente una instancia de AsignaturaRepository
    private AsignaturaRepository asignaturaRepository; //Objeto que se utiliza para acceder a la db

    @Override //Anotación que indica que se esta sobreescribiendo un metodo definido en la interfaz 
    public List<Asignatura> obtenerTodas() { //llamada al metodo finAll() del repositorio para devolver todas las asignaturas
        return asignaturaRepository.findAll();
    }

    @Override //Anotación que permite buscar una asignatura por su ID usando el metodo findById(id)
    public Optional<Asignatura> obtenerPorId(Long id) { //Devuelve un optional que puede contener o no la asignatura
        return asignaturaRepository.findById(id); //Evitando errores null
    }

    @Override //Anotación que guarda o actualiza una asignatura en la base de datos usando save()
    public Asignatura guardar(Asignatura asignatura) { //Spring Data JPA detecta si es una nueva asignatura
        return asignaturaRepository.save(asignatura); //o una actualización por el ID
    }

    @Override //Anotación que permite eliminar una asignatura por su ID usando el metodo deleteById() del respositorio
    public void eliminar(Long id) {
        asignaturaRepository.deleteById(id);
    }
}
