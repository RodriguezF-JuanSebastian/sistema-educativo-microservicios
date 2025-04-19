/*
 * SERVICIO DE USUARIOS - LÓGICA DE NEGOCIO
 * Esta clase representa el componente de servicio dentro del microservicio `usuarios-service`,
 * y es responsable de encapsular la lógica de negocio relacionada con la gestión de usuarios
 * (como estudiantes y docentes) en el sistema educativo.
 * 
 * FUNCIONES PRINCIPALES:
 * Obtener todos los usuarios registrados en la base de datos.
 * Buscar un usuario específico por su ID
 * Guardar un nuevo usuario o actualizar uno existente.
 * Eliminar un usuario por su ID.
 * 
 * INTERACCIÓN:
 * - Este servicio es consumido por los controladores REST del microservicio.
 * - A su vez, se apoya en el repositorio JPA `UsuarioRepository` para interactuar con la base de datos.
 * 
 * EJEMPLO DE USO:
 * - Desde un controlador, se puede llamar a `usuarioService.obtenerUsuarioPorId(id)`
 * para obtener los detalles de un usuario específico.
 */

 //Indica el paquete al que pertenece esta clase
package com.edu.usuariosservice.servicios;

import com.edu.usuariosservice.modelos.Rol;
//Importa las clases del proyecto que se encuentran en otros paquetes
import com.edu.usuariosservice.modelos.Usuario; //Es la entidad que representa a un usuario en la db
import com.edu.usuariosservice.repositorios.RolRepository;
//Es el repositorio que permite acceder a los datos almacenados de los usuarios
import com.edu.usuariosservice.repositorios.UsuarioRepository; 
//Permite inyectar dependencias automaticamente como el repositorio
import org.springframework.beans.factory.annotation.Autowired; 
//Marca la clase como un componente de servicio gestionado por Spring
import org.springframework.stereotype.Service;
import java.util.Collections;
import com.edu.usuariosservice.excepciones.UsuarioNoEncontradoException;

import java.util.HashSet;
//Importa las librerias estandar de java
import java.util.List; //Representa una lista de elementos
import java.util.Optional; //Representa un objeto que puede o no contener un valor 

@Service //Indica que esta clase es un servicio de negocio en la arquitectura Spring, Spring la detecta y la gestiona
//Declara la clase UsuarioService que se encarga de implementar la logica del negocio relacionada con los usuarios
public class UsuarioService { 

    //Spring inyecta automaticamente una instancia del UsuarioRepository cuando se crea el UsuarioService
    //Así no se requiere de instanciar manualmente 
    @Autowired 
    //Declara una variable para el repositorio y es usada para acceder a la db de usuarios
    private UsuarioRepository usuarioRepository; 
    private final RolRepository rolRepository;


    public List<Usuario> obtenerTodosLosUsuarios() { //Metodo publico que devuelve una lista de todos los usuarios
        //findAll() es un metodo heredado del JpaRepository
        return usuarioRepository.findAll();
    }

    // Esto inyectará automáticamente el repositorio de roles.
    public UsuarioService(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    public Optional<Usuario> obtenerUsuarioPorId(Long id) { //Metodo que busca usuario por Id 
        return usuarioRepository.findById(id); //Devuelve un optional que puede contener el usuario o estar vacio si no existe
    }

    public Usuario guardarUsuario(Usuario usuario) { //Guarda un nuevo usuario o actualiza 
        return usuarioRepository.save(usuario); //save() es un metodo estandar de JPA
    }

    public void eliminarUsuario(Long id) { //Elimina un usuario de la base de datos segun su id
        usuarioRepository.deleteById(id);
    }

    //*******************************************************************************************

    public List<Usuario> obtenerUsuariosPorTipoUsuario(String tipoUsuario){
        return usuarioRepository.findByTipoUsuario(tipoUsuario);
    }

    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado){
        return usuarioRepository.findById(id).map(usuario ->{
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setEmail(usuarioActualizado.getEmail());
            usuario.setTipoUsuario(usuarioActualizado.getTipoUsuario());
            usuario.setTelefono(usuarioActualizado.getTelefono());
            usuario.setDireccion(usuarioActualizado.getDireccion());
            usuario.setFechaNacimiento(usuarioActualizado.getFechaNacimiento());
            usuario.setEstado(usuarioActualizado.getEstado());
            return usuarioRepository.save(usuario);
        }).orElseThrow(()-> new UsuarioNoEncontradoException("usuario con Id " + id + " no encontrado"));
    }

    // Método para actualizar el password
    public void actualizarPassword(Long id, String newPassword) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
        usuario.setPassword(newPassword);  // Aquí actualizamos la contraseña
        usuarioRepository.save(usuario);   // Guardamos el usuario con el nuevo password
    } 

    public Usuario crearUsuarioConRol(String email, String password, String rolNombre) {
        // Crear el usuario
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setPassword(password);  // Asegúrate de encriptar la contraseña

        // Asignar el rol
        Rol rol = rolRepository.findByNombre(rolNombre).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        usuario.setRoles(new HashSet<>(Collections.singletonList(rol)));

        return usuarioRepository.save(usuario);
    }
}