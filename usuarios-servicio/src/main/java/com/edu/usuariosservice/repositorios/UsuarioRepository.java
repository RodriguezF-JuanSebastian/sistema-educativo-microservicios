/*
 * UsuarioRepository.java
 * 
 * Esta interfaz representa el repositorio de acceso a datos para la entidad Usuario.
 * Extiende JpaRepository, lo que permite realizar operaciones CRUD (crear, leer, actualizar, eliminar)
 * directamente sobre la base de datos sin necesidad de implementar métodos manualmente.
 * 
 * Al estar anotada con @Repository, Spring la detecta automáticamente como un componente de acceso a datos.
 */

 //Define el paquete donde se ubica esta interfaz
 //Ayuda a organizar el codigo del proyecto por capas en este caso capa de acceso a datos 
package com.edu.usuariosservice.repositorios;

//Importa la clase usuario que es la entidad con la que trabajara este repositorio 
import com.edu.usuariosservice.modelos.Usuario;
//Importa JpaRepository que es una interfaz de Spring Data JPA 
//Proporciona todos los metodos basicos para manipular datos: save, findById, findAll, deleteById
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Anotación que marca la interfaz como un repositorio 
//Declara la interfaz UsuarioRepository que extiende JpaRepository
//Usuario: es la entidad que maneja el repositorio
//Long: es el tipo de identificador ID de la entidad
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByTipoUsuario(String tipoUsuario);

    Optional<Usuario> findByEmail(String email);
}