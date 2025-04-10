/*
 * Repositorio para la entidad Asignatura.
 * Esta interfaz extiende JpaRepository, lo que permite acceder automáticamente
 * a métodos CRUD (crear, leer, actualizar y eliminar) sin necesidad de implementarlos.
 * Spring Data JPA se encarga de generar las consultas SQL necesarias en tiempo de ejecución,
 * lo que simplifica el acceso a la base de datos.
 * Al estar anotada con @Repository, Spring la detecta como un componente de persistencia.
 */

 //Define la interfaz a la que pertenece el paquete
package com.edu.asignaturas_servicio.repository;

//Importa la clase asignatura que representa la entidad de la base de datos con la cual se trabajara
import com.edu.asignaturas_servicio.entity.Asignatura; 
//Importa JpaRepository que es la interfaz de Spring Data JPA que proporciona metodos genericos para trabajar 
//con base de datos como finAll(), findById(), save(), deleteById()
import org.springframework.data.jpa.repository.JpaRepository;
//Importa anotación Repository que marca esta interfaz como un componente de persistencia 
//permitiendo que Spring la gestione e inyecte como dependencia
import org.springframework.stereotype.Repository;

@Repository //Anotación que indica que esta interfaz es un componente de acceso a datos
//AsignaturaRepository nombre de la interfaz que define el respositorio para la entidad Asignatura
//extends JpaRepository<Asignatura, long> hereda todos los metodos de JpaRepository
//El primer parametro Asignatura indica el tipo de identidad 
//El segundo parametro Long indica el tipo de dato del ID de la entidad
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
}
