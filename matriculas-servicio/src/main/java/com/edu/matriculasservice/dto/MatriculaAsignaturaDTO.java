package com.edu.matriculasservice.dto;

public class MatriculaAsignaturaDTO {

    private Long id;
    private String nombre;
    private String descripcion;

    // Constructor vacío
    public MatriculaAsignaturaDTO() {
    }

    // Constructor con todos los campos
    public MatriculaAsignaturaDTO(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

