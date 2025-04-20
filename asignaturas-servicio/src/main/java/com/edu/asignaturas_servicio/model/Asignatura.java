/*
 * Clase entidad que representa la tabla "asignaturas" en la base de datos.
 * Utiliza anotaciones de Jakarta Persistence (JPA) para mapear los atributos
 * de esta clase a columnas de la tabla.
 * 
 * Contiene un identificador único (id), el nombre y una descripción de la asignatura.
 * 
 * Incluye:
 * - Constructor vacío (obligatorio para JPA).
 * - Constructor con parámetros.
 * - Métodos getters y setters para acceder y modificar los atributos.
 */

//Declara que esta clase esta dentro del paquete entity el cual contine las entidades JPA del proyecto
package com.edu.asignaturas_servicio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

    // Getters y setters
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
