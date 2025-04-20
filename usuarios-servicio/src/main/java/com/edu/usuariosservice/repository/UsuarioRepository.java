/*
* UsuarioRepository.java
* 
*Esta interfaz representa el repositorio de acceso a datos para la entidad Usuario.
*Extiende JpaRepository, lo que permite realizar operaciones CRUD (crear, leer, actualizar, eliminar)
*directamente sobre la base de datos sin necesidad de implementar métodos manualmente.
*
*Al estar anotada con @Repository, Spring la detecta automáticamente como un componente de acceso a datos.
*/

//Define el paquete donde se ubica esta interfaz
//Ayuda a organizar el codigo del proyecto por capas en este caso capa de acceso a datos 
package com.edu.usuariosservice.repository;

import com.edu.usuariosservice.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByTipoUsuario(String tipoUsuario);
}