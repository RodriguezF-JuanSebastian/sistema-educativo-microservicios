/*
 * Servicio de lógica del microservicio de matrículas.
 * Este servicio contiene lógica para interactuar con el microservicio de usuarios
 * a través de un cliente REST (`UsuarioClient`), obteniendo datos de un usuario
 * en función de su ID.
 * 
 * Permite desacoplar la lógica de negocio del controlador y facilita el uso
 * de la arquitectura basada en microservicios mediante llamadas entre servicios.
 * 
 * Este servicio representa un ejemplo claro de comunicación entre microservicios usando Feign Client
 */

//Indica que este archivo forma parte del paquete servicios del microservicio matriculasservice
package com.edu.matriculasservice.servicios;

//importa clases que se encuentran en el paquete clientes
//un cliente REST usando @FeingClient que se encarga de comunicarse con el microservicio de usuarios
import com.edu.matriculasservice.clientes.UsuarioClient; 
//Un objeto de transferencia de datos que encapsula la información del usuario que se recibe desde otro microservicio
import com.edu.matriculasservice.clientes.MatriculaUsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired; //Para inyectar dependencias automaticamente
import org.springframework.stereotype.Service; //Para declarar esta clase como un servicio dentro del contexto de Spring

import com.edu.matriculasservice.modelos.Matricula;
import com.edu.matriculasservice.repositorio.MatriculaRepository;

import java.util.List;
import java.util.Optional;


@Service //Anotación que indica que esta clase representa un componente de servicio, contiene logica del servicio reutilizable
public class MatriculaService { //Es el componente donde se centraliza la logica relacionada con las matriculas

    @Autowired //Anotación que inyecta automaticamente una instancia del UsuarioClient
    //Este cliente permite realizar peticiones HTTP al microservicio de usuarios como obtener datos por ID
    private UsuarioClient usuarioClient;

    @Autowired 
    private MatriculaRepository matriculaRepository;

    //Define un metodo publico que recibe un IdUsuario y devuelve un objeto MatriculaUsuarioDTO 
    //Llama al metodo obtenerUsuarioPorId() del cliente usuarioClient para recuperar la información del
    //usuario desde otro microservicio
    //Sirve para consumir el microservicio de usuario desde el microservicio de matriculas
    public MatriculaUsuarioDTO obtenerDatosUsuario(Long idUsuario) {
        return usuarioClient.obtenerUsuarioPorId(idUsuario);
    }

    // Guardar una nueva matrícula
    public Matricula guardarMatricula(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    // Obtener todas las matrículas
    public List<Matricula> obtenerTodasLasMatriculas() {
        return matriculaRepository.findAll();
    }

    // Obtener una matrícula por ID
    public Optional<Matricula> obtenerMatriculaPorId(Long id) {
        return matriculaRepository.findById(id);
    }

    // Eliminar una matrícula por ID
    public void eliminarMatricula(Long id) {
        matriculaRepository.deleteById(id);
    }
}