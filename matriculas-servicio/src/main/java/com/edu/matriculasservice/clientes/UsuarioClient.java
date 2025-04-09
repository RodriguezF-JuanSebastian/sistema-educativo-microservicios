package com.edu.matriculasservice.clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuarios-service")
public interface UsuarioClient {

    @GetMapping("/usuarios/{id}")
    MatriculaUsuarioDTO obtenerUsuarioPorId(@PathVariable("id") Long id);
}