/*
 * Clase DTO (Data Transfer Object) que representa los datos básicos de un usuario
 * transferidos desde el microservicio `usuarios-service` hacia `matriculas-service`.
 * 
 * Se utiliza principalmente para transportar:
 * - id: Identificador único del usuario
 * - nombre: Nombre del usuario
 * - tipo: Rol del usuario (ej. "estudiante", "docente")
 * 
 * Este objeto es usado por el Feign Client `UsuarioClient` para recibir la respuesta del endpoint remoto de usuarios.
 */

//Define el paquete al que pertenece la clase
package com.edu.matriculasservice.clientes;

import java.time.LocalDate;


//Declaracion de la clase publica 
//DTO significa DATA TRANSFER OBJECT y su proposito es transportar datos entre capas o servicios sin exponer
//directamente entidades
public class MatriculaUsuarioDTO {

    //Atributos privados que definen la estructura del objeto 
    private Long id; //Identificador de usuario
    private String nombre; //Nombre completo o identificativo
    private String rol; // Tipo de usuario por ejemplo: "estudiante" o "docente"
    private String email;
    private String telefono;
    private String direccion;
    private LocalDate fechaNacimiento;
    private Boolean estado;

    // Constructor vacío necesario para que framworks como Jackson puedan crear objetos automaticamente
    public MatriculaUsuarioDTO() {}

    // Constructor con parámetros que inicializa el objeto directamente con valores para sus tres campos
    public MatriculaUsuarioDTO(Long id, String nombre, String rol, String email, String telefono, String direccion, String fechaNacimiento, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento);
        this.estado = estado;
    }

    // Metodos Getters y Setters para acceder y modificar cada uno de los atributos
    //Son necesarios para trabajar con Frameworks que dependen de la manipulación de objetos tipo
    //JavaBean como Jackson o Spring
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}