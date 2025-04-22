/*
 * UserCredentials
 * Esta clase será la que usamos para enviar los datos del login (usuario y contraseña) desde el frontend o el cliente
 */

package com.edu.authservice.dto;

public class UserCredentials {

    private String email;
    private String password;

    // Constructor vacío
    public UserCredentials() {}

    // Constructor con parámetros
    public UserCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters y Setters
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
}