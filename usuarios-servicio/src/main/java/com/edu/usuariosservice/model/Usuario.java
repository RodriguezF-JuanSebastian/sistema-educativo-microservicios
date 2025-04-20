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
package com.edu.usuariosservice.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String password;
    private String tipoUsuario;
    private String telefono;
    private String direccion;
    private LocalDate fechaNacimiento;
    private Boolean estado;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "usuario_roles",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<Rol> roles = new HashSet<>();

    // Constructor vacío y constructor completo
    public Usuario() {}

    public Usuario(Long id, String nombre, String email, String password, String tipoUsuario,
                   String telefono, String direccion, LocalDate fechaNacimiento, Boolean estado) {
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

    // Getters y Setters (los que ya te compartí antes)

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTipoUsuario() {
        return tipoUsuario;
    }
    
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    public Boolean getEstado() {
        return estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    // Metodos

    @Override
    public String getUsername() {
        return email;  // Este método debe devolver el nombre de usuario, en este caso el email
    }

    @Override
    public String getPassword() {
        return password;  // Este método devuelve la contraseña
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> tipoUsuario);  // Aquí asignamos el tipo de usuario como autoridad
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // Si la cuenta no ha expirado
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // Si la cuenta no está bloqueada
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Si las credenciales no han expirado
    }

    @Override
    public boolean isEnabled() {
        return estado;  // El estado determina si la cuenta está habilitada
    }
}