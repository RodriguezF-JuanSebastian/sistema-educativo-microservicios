package com.edu.matriculasservice.servicios.impl;

import com.edu.matriculasservice.clientes.UsuarioClient;
import com.edu.matriculasservice.clientes.AsignaturaClient;
import com.edu.matriculasservice.dto.MatriculaAsignaturaDTO;
import com.edu.matriculasservice.dto.MatriculaUsuarioDTO;
import com.edu.matriculasservice.dto.MatriculaDetalleDTO;
import com.edu.matriculasservice.entidades.Matricula;
import com.edu.matriculasservice.repositorios.MatriculaRepository;
import com.edu.matriculasservice.servicios.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private UsuarioClient UsuarioClient;

    @Autowired
    private AsignaturaClient AsignaturaClient;

    @Override
    public Matricula guardar(Matricula matricula) {
        // Obtener los detalles del usuario y la asignatura
        MatriculaUsuarioDTO usuario = UsuarioClient.obtenerUsuarioPorId(matricula.getUsuarioId());
        MatriculaAsignaturaDTO asignatura = AsignaturaClient.getAsignatura(matricula.getAsignaturaId());

        // Aquí se asignan los detalles a la matrícula
        matricula.setNombreUsuario(usuario.getNombre());  // Asignando nombre del usuario
        matricula.setNombreAsignatura(asignatura.getNombre());  // Asignando nombre de la asignatura
        matricula.setDescripcionAsignatura(asignatura.getDescripcion());  // Asignando descripción de la asignatura

        // Lógica de guardado de matrícula (ahora incluye los detalles)
        return matriculaRepository.save(matricula);
    }
    @Override
    public List<Matricula> obtenerTodas() {
        return matriculaRepository.findAll();
    }

    @Override
    public Optional<Matricula> obtenerPorId(Long id) {
        return matriculaRepository.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        matriculaRepository.deleteById(id);
    }

    @Override
    public Matricula actualizar(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    public MatriculaUsuarioDTO obtenerUsuarioDeMatricula(Long usuarioId) {
        return UsuarioClient.obtenerUsuarioPorId(usuarioId);  // Llamada al microservicio de usuarios
    }

    // Método adicional para obtener detalles completos de una matrícula
    public MatriculaDetalleDTO obtenerMatriculaConDetalles(Long id) {
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matrícula no encontrada con ID: " + id));

        MatriculaUsuarioDTO usuario = UsuarioClient.obtenerUsuarioPorId(matricula.getUsuarioId());
        MatriculaAsignaturaDTO asignatura = AsignaturaClient.getAsignatura(matricula.getAsignaturaId());

        return new MatriculaDetalleDTO(matricula.getId(), usuario, asignatura);
    }
}
