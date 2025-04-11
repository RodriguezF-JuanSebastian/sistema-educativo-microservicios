/*
 * Usuario.java
 * 
 * Esta clase representa la entidad Usuario dentro del sistema.
 * Está mapeada a la tabla "usuarios" de la base de datos mediante anotaciones JPA.
 * Define los atributos básicos de un usuario (id, nombre, email), junto con sus métodos
 * getter y setter necesarios para manipularlos.
 * También incluye un constructor vacío (requerido por JPA) y un constructor con parámetros.
 */

//Define el paquete donde se encuentra clase en este caso modelos que contiene las entidades del sistema
package com.edu.usuariosservice.modelos;

//Importa las anotaciones necesarias de Jakarta Persistence API (JPA) para mapear esta clase a una base de datos 
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity //Indica que esta clase es una entidad JPA lo que significa que sera mapeada a una tabla en la db
@Table(name = "usuarios") //Define el nombre de la tabla en la base de datos a la que se va a mapear esta clase usuarios
public class Usuario { //Declara la clase usuario que representara a cada fila de la tabla usuarios

    @Id //Indica que este cambo (id) es la clave primaria de la tabla
    //Indica que el valor ID sera generado automaticamente por la db autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; //Atributo que representa el identificador unico de cada usuario

    @NotBlank
    private String nombre; //Atributo que almacena el nombre del usuario
    @Email
    private String email; //Atributo que almacena el correo electronico del usuario
    @NotBlank
    private String password; //Atributo para almacenar la contraseña de usuario
    private String rol; //Atributo para almacenar el rol de los usuarios
    public Usuario() { //Constructor vacio obligatorio para que JPA pueda crear instancias de la entidad
    }

    //Constructor que permite crear objetos usuario de forma mas directa pasando los valores por parametro
    public Usuario(Long id, String nombre, String email, String password, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    //Metodos Getter y Setter para cada atributo de la clase
    //Son usados para acceder y modificar los valores privados desde otas clases 
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}