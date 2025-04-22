package com.edu.authservice.dto;

/*
 * UserDetailsDTO
 * Esta clase representa al usuario una vez que ha sido autenticado. 
 * También será útil agregar roles en el futuro
 */
public class UserDetailsDTO {

    private String email;
    private String nombreCompleto;
    private String token; 

    // Constructor vacío
    public UserDetailsDTO() {}

    // Constructor con parámetros
    public UserDetailsDTO(String email, String nombreCompleto) {
        this.email = email;
        this.nombreCompleto = nombreCompleto;
    }

    // Getters y Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    // Getter y Setter para el token
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}