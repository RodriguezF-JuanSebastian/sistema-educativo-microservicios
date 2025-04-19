package com.edu.matriculasservice.servicios;

import com.edu.matriculasservice.dto.MatriculaResponseDTO;
import com.edu.matriculasservice.modelos.Matricula;
import com.edu.matriculasservice.clientes.MatriculaUsuarioDTO;
import java.util.List;
import java.util.Optional;

public interface IMatriculaService {
    
    // Crear una nueva matrícula
    Matricula crearMatricula(Matricula matricula);

    // Obtener todas las matrículas
    List<Matricula> obtenerTodasLasMatriculas();

    // Obtener una matrícula por su ID
    Optional<MatriculaResponseDTO> obtenerMatriculaDTOporId(Long id);

    // Eliminar una matrícula por su ID
    void eliminarMatricula(Long id);

    // Obtener los datos del usuario relacionado con la matrícula (seguramente desde otro microservicio)
    MatriculaUsuarioDTO obtenerDatosUsuario(Long id);

    Matricula guardarMatricula(Matricula matricula);
}