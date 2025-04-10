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

//DEfine el paquete al que pertenece la clase
package com.edu.matriculasservice.clientes;

//Declaracion de la clase publica 
//DTO significa DATA TRANSFER OBJECT y su proposito es transportar datos entre capas o servicios sin exponer
//directamente entidades
public class MatriculaUsuarioDTO {

    //Atributos privados que definen la estructura del objeto 
    private Long id; //Identificador de usuario
    private String nombre; //Nombre completo o identificativo
    private String tipo; // Tipo de usuario por ejemplo: "estudiante" o "docente"

    // Constructor vacío necesario para que framworks como Jackson puedan crear objetos automaticamente
    public MatriculaUsuarioDTO() {}

    // Constructor con parámetros que inicializa el objeto directamente con valores para sus tres campos
    public MatriculaUsuarioDTO(Long id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}