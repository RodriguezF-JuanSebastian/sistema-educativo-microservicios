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
 package com.edu.usuariosservice.service;

 import com.edu.usuariosservice.model.Usuario;
 import java.util.List;
 import java.util.Optional;
 
 public interface UsuarioService {
     List<Usuario> obtenerTodosLosUsuarios();
     Optional<Usuario> obtenerUsuarioPorId(Long id);
     Usuario guardarUsuario(Usuario usuario);
     void eliminarUsuario(Long id);
     Usuario actualizarUsuario(Long id, Usuario usuario);
     List<Usuario> obtenerUsuariosPorTipoUsuario(String tipoUsuario);
     void actualizarPassword(Long id, String nuevaPassword);
 }