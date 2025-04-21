package com.edu.matriculasservice.service;

import com.edu.matriculasservice.client.UsuarioFeignClient;
import com.edu.matriculasservice.client.AsignaturaFeignClient;
import com.edu.matriculasservice.dto.MatriculaResponseDto;
import com.edu.matriculasservice.model.Matricula;
import com.edu.matriculasservice.model.Usuario;
import com.edu.matriculasservice.model.Asignatura;
import com.edu.matriculasservice.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final UsuarioFeignClient usuarioFeignClient;
    private final AsignaturaFeignClient asignaturaFeignClient;

    public MatriculaServiceImpl(MatriculaRepository matriculaRepository,
                                UsuarioFeignClient usuarioFeignClient,
                                AsignaturaFeignClient asignaturaFeignClient) {
        this.matriculaRepository = matriculaRepository;
        this.usuarioFeignClient = usuarioFeignClient;
        this.asignaturaFeignClient = asignaturaFeignClient;
    }

    @Override
    public void registrarMatricula(Long usuarioId) {
        Usuario usuario = usuarioFeignClient.obtenerUsuarioPorId(usuarioId);
        System.out.println("Usuario: " + usuario.getNombre());
        // lógica de matrícula
    }

    @Override
    public List<Matricula> obtenerTodas() {
        return matriculaRepository.findAll();
    }

    @Override
    public Matricula guardar(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula obtenerPorId(Long id) {
        return matriculaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        matriculaRepository.deleteById(id);
    }

@Override
public List<MatriculaResponseDto> obtenerTodasConDetalle() {
    List<Matricula> matriculas = matriculaRepository.findAll();
    List<MatriculaResponseDto> respuesta = new ArrayList<>();

    for (Matricula matricula : matriculas) {
        Usuario usuario = usuarioFeignClient.obtenerUsuarioPorId(matricula.getEstudianteId());
        Asignatura asignatura = asignaturaFeignClient.obtenerAsignaturaPorId(matricula.getAsignaturaId());

        MatriculaResponseDto dto = new MatriculaResponseDto();
        dto.setId(matricula.getId());
        dto.setEstudianteId(matricula.getEstudianteId());
        dto.setAsignaturaId(matricula.getAsignaturaId());

        // Datos del usuario
        dto.setNombre(usuario.getNombre());
        dto.setEmail(usuario.getEmail());
        dto.setTipoUsuario(usuario.getTipoUsuario());

        // Datos de la asignatura
        dto.setNombreAsignatura(asignatura.getNombre());
        dto.setDescripcionAsignatura(asignatura.getDescripcion());

        respuesta.add(dto);
        }

    return respuesta;
    }

    @Override
public MatriculaResponseDto obtenerMatriculaConUsuario(Long id) {
    Matricula matricula = matriculaRepository.findById(id).orElse(null);
    if (matricula == null) {
        return null;
    }

    Usuario usuario = usuarioFeignClient.obtenerUsuarioPorId(matricula.getEstudianteId());
    Asignatura asignatura = asignaturaFeignClient.obtenerAsignaturaPorId(matricula.getAsignaturaId());

    MatriculaResponseDto dto = new MatriculaResponseDto();
    dto.setId(matricula.getId());
    dto.setEstudianteId(matricula.getEstudianteId());
    dto.setAsignaturaId(matricula.getAsignaturaId());

    // Datos del usuario
    dto.setNombre(usuario.getNombre());
    dto.setEmail(usuario.getEmail());
    dto.setTipoUsuario(usuario.getTipoUsuario());

    // Datos de la asignatura
    dto.setNombreAsignatura(asignatura.getNombre());
    dto.setDescripcionAsignatura(asignatura.getDescripcion());

    return dto;
}
}   
