package com.edu.matriculasservice.dto;

import com.edu.matriculasservice.clientes.MatriculaUsuarioDTO;
import com.edu.matriculasservice.clientes.MatriculaAsignaturaDTO;

public class MatriculaResponseDTO {

    private Long id;
    private MatriculaUsuarioDTO usuario;
    private MatriculaAsignaturaDTO asignatura;

    public MatriculaResponseDTO() {
    }

    public MatriculaResponseDTO(Long id, MatriculaUsuarioDTO usuario, MatriculaAsignaturaDTO asignatura) {
        this.id = id;
        this.usuario = usuario;
        this.asignatura = asignatura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MatriculaUsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(MatriculaUsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public MatriculaAsignaturaDTO getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(MatriculaAsignaturaDTO asignatura) {
        this.asignatura = asignatura;
    }
}