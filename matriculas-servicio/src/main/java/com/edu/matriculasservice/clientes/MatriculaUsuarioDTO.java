package com.edu.matriculasservice.clientes;

public class MatriculaUsuarioDTO {

    private Long id;
    private String nombre;
    private String tipo; // por ejemplo: "estudiante" o "docente"

    // Constructor vacío
    public MatriculaUsuarioDTO() {}

    // Constructor con parámetros
    public MatriculaUsuarioDTO(Long id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}