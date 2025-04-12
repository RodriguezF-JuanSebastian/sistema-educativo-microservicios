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

import com.edu.matriculasservice.entidades.Matricula;
import com.edu.matriculasservice.dto.MatriculaUsuarioDTO;
import java.util.List;
import java.util.Optional;

public interface MatriculaService {
    Matricula guardar(Matricula matricula);
    List<Matricula> obtenerTodas();
    Optional<Matricula> obtenerPorId(Long id);
    void eliminar(Long id);
    Matricula actualizar(Matricula matricula);
    MatriculaUsuarioDTO obtenerUsuarioDeMatricula(Long usuarioId);
}


