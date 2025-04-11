/*
 * UsuarioController.java
 * Este controlador maneja las operaciones HTTP relacionadas con la entidad Usuario.
 * Expone una API REST con endpoints para listar, buscar, crear y eliminar usuarios.
 * Se comunica con el servicio UsuarioService para realizar las operaciones necesarias sobre la base de datos.
 * 
 * Endpoints:
 * - GET /usuarios           → Listar todos los usuarios
 * - GET /usuarios/{id}      → Buscar un usuario por su ID
 * - POST /usuarios          → Crear un nuevo usuario
 * - DELETE /usuarios/{id}   → Eliminar un usuario por su ID
 */

 //Define el paquete al que pertenece la clase en este caso forma parte de la capa de controladores del microservicio 
package com.edu.usuariosservice.controladores;

//Importa la clase usuario (modelo de datos) y el usuarioService (logica de negocio) necesario para el controlador
import com.edu.usuariosservice.modelos.Usuario;
import com.edu.usuariosservice.servicios.UsuarioService;
//Anotación que inyecta automaticamente dependencias como el servicio
import org.springframework.beans.factory.annotation.Autowired;
//Importa anotaciones de SPring necesarias para construir una API REST como @RestController @GetMapping, @PostMapping
import org.springframework.web.bind.annotation.*;

//Importa las clases denecesarias para manejar lista de usuarios y resultados opcionales en caso de que no se encuentre user
import java.util.List;
import java.util.Optional;

@RestController //Declara que esta clase es un controlador REST lo que permite exponer metodos como endpoint HTTP 
@RequestMapping("/usuarios") //Define la ruta base para todos los endpoint de esta clase, todas las rutas empezaran /usuarios
//Define la clase UsuarioController la cual contiene los endpoints del microservicio usuarios-service 
public class UsuarioController { 

    @Autowired //Anotación que inyecta automaticamente una instancia del servicio para utilizar sus metodos
    private UsuarioService usuarioService;

    //Enpoint obtener todos los usuarios

    // GET - Listar todos los usuarios
    //Mapea una solicitud HTTP GET a /usuarios
    //Devuelve una lista completa de usuarios llamando al metodo obtenerTodosLosUsuarios() del servicio 
    @GetMapping 
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerTodosLosUsuarios();
    }

    //Enpoint obtener un usuario por ID

    // GET - Buscar usuario por ID
    @GetMapping("/{id}") // Mapea una solicitud GET a /usuarios/{id}
    //El valor {id} se recibe como parametro mediante @PathVariable
    //Retorna un Optional<Usuario> que puede contener un usuario si existe
    public Optional<Usuario> obtenerPorId(@PathVariable Long id) { 
        return usuarioService.obtenerUsuarioPorId(id); 
    }

    //Endpoint crear un nuevo usuario

    // POST - Crear nuevo usuario
    @PostMapping //Mapea una solicitud POST a /usuarios
    //El cuerpo de la solicitud HTTP se convierte automaticamente en un objeto usuario gracias a @RequestBody
    //Guarda el nuevo usuario usando el metodo del servicio
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    //Enpoint eliminar un usuario por ID

    // DELETE - Eliminar usuario por ID
    @DeleteMapping("/{id}") //Mapea una solicitud DELETE a /usuarios/{id}
    public void eliminarUsuario(@PathVariable Long id) { //Elimina el usuario correspondiente al ID recibido usando el servicio
        usuarioService.eliminarUsuario(id);
    }
    //Actualizar usuarios por ID

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        return usuarioService.actualizarUsuario(id, usuarioActualizado);
    }

}