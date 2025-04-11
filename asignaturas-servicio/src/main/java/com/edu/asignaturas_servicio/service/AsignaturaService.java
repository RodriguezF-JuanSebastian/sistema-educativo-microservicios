/*
 * Interfaz del servicio de Asignaturas para el microservicio "asignaturas-servicio".
 * Esta interfaz define los métodos que deben ser implementados para gestionar
 * las operaciones relacionadas con las asignaturas, como obtener, guardar y eliminar.
 * Los métodos definidos aquí serán implementados por una clase de servicio
 * concreta (por ejemplo, AsignaturaServiceImpl) que contendrá la lógica de negocio.
 * Métodos principales:
 * - obtenerTodas(): lista todas las asignaturas.
 * - obtenerPorId(Long id): busca una asignatura por su ID.
 * - guardar(Asignatura asignatura): guarda o actualiza una asignatura.
 * - eliminar(Long id): elimina una asignatura por su ID.
 */

 //DEfine que la interfaz pertenece al paquete service del microservicio asignaturas_servicio
package com.edu.asignaturas_servicio.service; 

//Función que importa la clase asignatura, que se encuentra en el paquete entity
//Se necestia porque los metodos de esta interfaz utilizan objetos de tipo asignatura
import com.edu.asignaturas_servicio.entity.Asignatura;

//Función que importa las clases de java necesarias para trabajar con, List para retornar listas de asignaturas
//para manejar resultados que pueden ser nullos como una asignatura por ID
import java.util.List;
import java.util.Optional;

//Función que declara la interfaz llamada AsignaturaService
//Su uso es para definir el contrato que deben cumplir las clases que implementan esta interfaz 
//como AsignaturaServiceImpl, permite una arquitectura limpia y facilita el uso de pruebas, inyecciones de 
//dependencias y el mantenimiento
public interface AsignaturaService {
    //Función metodo que debe devolver una lista de todas las asignaturas y se usa para mostras todas las asignaturas
    //registradas en el sistema
    List<Asignatura> obtenerTodas();
    //Función metodo que devuelve una asignatura especifica por su ID encapsulada en un optional
    //Su uso es prevenir los errores de null cuando no se encuentra una asignatura con el ID dado
    Optional<Asignatura> obtenerPorId(Long id);
    //Función metodo que guarda una nueva asignatura o actualiza una existente
    //Recibe un parametro Asignatura y devuelve la asignatura guardada con su ID generado si es nueva
    Asignatura guardar(Asignatura asignatura);
    //Función metodo para eliminar una asignatura por su ID, su uso borrar del sistema la asignatura indicadas
    void eliminar(Long id);

    //Actualiza los datos de una asignatura ya existente
    //Recibe un objeto Asignatura con los cambios y retorna el objeto actualizado
    Asignatura actualizar(Asignatura asignatura);
}
