package com.edu.usuariosservice.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UsuarioDto {

    // Nombre completo del usuario
    private String nombre;
    // Correo electrónico del usuario
    private String email;
    // Contraseña en texto plano (será encriptada antes de guardar)
    private String password;
    // Rol del usuario, por ejemplo: "ROLE_ADMIN", "ROLE_ESTUDIANTE", etc.
    private String rol;
    // Dirección física del usuario (opcional pero se almacena)
    private String direccion;
    // Número de teléfono del usuario
    private String telefono;
    // Fecha de nacimiento (formato esperado: "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    // Estado del usuario (activo = true, inactivo = false)
    private Boolean estado;
    // Tipo de usuario (por ejemplo: "estudiante", "docente", etc.)
    private String tipoUsuario;

}