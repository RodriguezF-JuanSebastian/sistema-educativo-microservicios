package com.edu.matriculasservice.clientes;

import com.edu.matriculasservice.dto.MatriculaUsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuarios-servicio", url = "http://harold-pc.lan:8082/usuarios")
public interface UsuarioClient {

    @GetMapping("/{id}")
    MatriculaUsuarioDTO obtenerUsuarioPorId(@PathVariable("id") Long id);
}

