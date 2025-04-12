package com.edu.matriculasservice.dto;

import java.time.LocalDate;

public class MatriculaDetalleDTO {
    private Long id;
    private Long usuarioId;
    private String nombreUsuario;
    private Long asignaturaId;
    private String nombreAsignatura;
    private String descripcion;
    private LocalDate fecha;

    // Constructor que estaba causando error (ahora agregado correctamente)
    public MatriculaDetalleDTO(Long id, MatriculaUsuarioDTO usuarioDTO, MatriculaAsignaturaDTO asignaturaDTO) {
        this.id = id;
        this.usuarioId = usuarioDTO.getId();
        this.nombreUsuario = usuarioDTO.getNombre();
        this.asignaturaId = asignaturaDTO.getId();
        this.nombreAsignatura = asignaturaDTO.getNombre();
        this.descripcion = asignaturaDTO.getDescripcion();
        this.fecha = LocalDate.now(); // o puedes dejarlo como null si lo manejas después
    }

    // Constructor completo
    public MatriculaDetalleDTO(Long id, Long usuarioId, String nombreUsuario, Long asignaturaId, String nombreAsignatura, String descripcion, LocalDate fecha) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nombreUsuario = nombreUsuario;
        this.asignaturaId = asignaturaId;
        this.nombreAsignatura = nombreAsignatura;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    // Getters y setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }

    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public String getNombreUsuario() { return nombreUsuario; }

    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public Long getAsignaturaId() { return asignaturaId; }

    public void setAsignaturaId(Long asignaturaId) { this.asignaturaId = asignaturaId; }

    public String getNombreAsignatura() { return nombreAsignatura; }

    public void setNombreAsignatura(String nombreAsignatura) { this.nombreAsignatura = nombreAsignatura; }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDate getFecha() { return fecha; }

    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}
