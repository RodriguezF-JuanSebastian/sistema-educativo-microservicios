package com.edu.matriculasservice.entidades;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "matriculas")

public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId;
    private Long asignaturaId;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public String getDescripcionAsignatura() {
        return descripcionAsignatura;
    }

    public void setDescripcionAsignatura(String descripcionAsignatura) {
        this.descripcionAsignatura = descripcionAsignatura;
    }

    private String nombreUsuario;  // Nuevo campo para almacenar el nombre del usuario
    private String nombreAsignatura;  // Nuevo campo para almacenar el nombre de la asignatura
    private String descripcionAsignatura;  // Nuevo campo para almacenar la descripción de la asignatura
    private LocalDate fecha;

    // Constructor vacío
    public Matricula() {
    }

    // Constructor con campos
    public Matricula(Long id, Long usuarioId, Long asignaturaId, LocalDate fecha) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.asignaturaId = asignaturaId;
        this.fecha = fecha;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Long getAsignaturaId() { return asignaturaId; }
    public void setAsignaturaId(Long asignaturaId) { this.asignaturaId = asignaturaId; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}

