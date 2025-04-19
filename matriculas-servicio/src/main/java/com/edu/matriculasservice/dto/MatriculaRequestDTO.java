package com.edu.matriculasservice.dto;

public class MatriculaRequestDTO {

    private Long usuarioId;
    private Long asignaturaId;

    public MatriculaRequestDTO() {
    }

    public MatriculaRequestDTO(Long usuarioId, Long asignaturaId) {
        this.usuarioId = usuarioId;
        this.asignaturaId = asignaturaId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Long asignaturaId) {
        this.asignaturaId = asignaturaId;
    }
}