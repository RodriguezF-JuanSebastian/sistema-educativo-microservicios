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
import java.time.LocalDate;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import java.util.List;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity //Indica que esta clase es una entidad JPA lo que significa que sera mapeada a una tabla en la db
@Table(name = "usuarios") //Define el nombre de la tabla en la base de datos a la que se va a mapear esta clase usuarios
public class Usuario implements UserDetails { //Declara la clase usuario que representara a cada fila de la tabla usuarios

    
    @Id //Indica que este cambo (id) es la clave primaria de la tabla
    //Indica que el valor ID sera generado automaticamente por la db autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; //Atributo que representa el identificador unico de cada usuario

    private String nombre; //Atributo que almacena el nombre del usuario 
    private String email; //Atributo que almacena el correo electronico del usuario
    private String password;
    private String tipoUsuario;
    private String telefono;
    private String direccion;
    private LocalDate fechaNacimiento;
    private Boolean estado;

    // Relación con la entidad Rol
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "usuario_roles", 
        joinColumns = @JoinColumn(name = "usuario_id"), 
        inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<Rol> roles = new HashSet<>(); // Usamos un Set para almacenar los roles del usuario

    public Usuario() { //Constructor vacio obligatorio para que JPA pueda crear instancias de la entidad
    }

    //Constructor que permite crear objetos usuario de forma mas directa pasando los valores por parametro
    public Usuario(Long id, String nombre, String email, String password, String tipoUsuario, String telefono, String direccion, LocalDate fechaNacimiento, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }

    //Metodos Getter y Setter para cada atributo de la clase
    //Son usados para acceder y modificar los valores privados desde otras clases 
    public Set<Rol> getRoles() {
        return roles;
    }
    
    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
    
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

    public void setTipoUsuario(String tipoUsuario){
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuario(){
        return tipoUsuario;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaNacimiento(){
        return fechaNacimiento;
    }

    public void setEstado(Boolean estado){
        this.estado = estado;
    }

    public Boolean getEstado(){
        return estado;
    }

    //*************************************************************************************

        // Métodos de la interfaz UserDetails

    @Override
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> tipoUsuario); 
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return estado;
    }
}
