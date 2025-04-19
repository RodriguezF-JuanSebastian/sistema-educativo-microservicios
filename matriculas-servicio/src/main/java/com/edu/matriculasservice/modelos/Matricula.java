package com.edu.matriculasservice.modelos;

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
    private LocalDate fechaMatricula;

    // Constructor vacío (requerido por JPA)
    public Matricula() {}

    // Constructor con campos
    public Matricula(Long usuarioId, Long asignaturaId, LocalDate fechaMatricula) {
        this.usuarioId = usuarioId;
        this.asignaturaId = asignaturaId;
        this.fechaMatricula = fechaMatricula;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }
}