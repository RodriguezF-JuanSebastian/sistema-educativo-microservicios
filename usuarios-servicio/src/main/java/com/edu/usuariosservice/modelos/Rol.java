package com.edu.usuariosservice.modelos;

import jakarta.persistence.*;
import java.util.Set;  // Importa Set

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre; // El nombre del rol, por ejemplo, "ROLE_ESTUDIANTE"

    @ManyToMany(mappedBy = "roles")
    private Set<Usuario> usuarios;

    public Rol() {}

    public Rol(String nombre) {
        this.nombre = nombre;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
