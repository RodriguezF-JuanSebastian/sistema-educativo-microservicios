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
package com.edu.asignaturas_servicio.entity;

//Estas son las anotaciones del JPA que permiten que Spring Boot sepa como mapear esta clase a una tabla de db
import jakarta.persistence.Entity; //Indica que esta clase es una entidad JPA
import jakarta.persistence.GeneratedValue; //Define como se genera automaticamente el ID
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; //Marca el campo que sera la clave primaria 
import jakarta.persistence.Table; //Especifica el nombre de la tabla en la base de datos

@Entity //Marca esta clase como una entidad persistente que se guardara en la db
@Table(name = "asignaturas") //Define que esta entidad se mapeara con la tabla asignaturas
public class Asignatura {

    @Id //Declara que el campo ID es la clave primaria 
    //Le dice a la base de datos que el valor del id se genera automaticamente 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; //Es el indicador unico de la asignatura 

    //Campos simples que se mapearan como columnas en la tabla asignaturas
    private String nombre;
    private String descripcion;

    private int creditos;

    // Constructor vacío requerido para poder instanciar la clase automaticamente
    public Asignatura() {
    }

    // Constructor util para crear objetos Asignatura directamente con sus atributos 
    public Asignatura(Long id, String nombre, String descripcion, int creditos) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
        this.descripcion = descripcion;
    }

    // Getters y setters
    //Metodos que permiten acceder (get) y modificar (set) los atributos de la clase
    //Todos estos metodos son parte de las reglas de encapsulamiento en Java y que permiten manejar
    //los atributos de forma segura
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

    public int getCreditos() {return creditos;}

    public void setCreditos(int creditos) {this.creditos = creditos;}

}
