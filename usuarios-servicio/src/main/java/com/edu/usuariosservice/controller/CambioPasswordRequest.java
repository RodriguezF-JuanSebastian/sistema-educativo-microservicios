/*
 * Mejorar semántica del endpoint de cambio de contraseña
 * ¿Por qué no usar @RequestParam?
 * Porque la contraseña no debería ir en la URL (ni como query param). 
 * Aunque sea un PUT, es más limpio y seguro recibirlo en el cuerpo del request como JSON.
 * 
 * 
 * ESTA CLASE:
 * Esta clase es simplemente una estructura que representa el cuerpo (body) 
 * del request cuando alguien quiera actualizar su contraseña.
 */

package com.edu.usuariosservice.controller;

public class CambioPasswordRequest {

    private String nuevaPassword;

    public String getNuevaPassword() {
        return nuevaPassword;
    }

    public void setNuevaPassword(String nuevaPassword) {
        this.nuevaPassword = nuevaPassword;
    }
}
