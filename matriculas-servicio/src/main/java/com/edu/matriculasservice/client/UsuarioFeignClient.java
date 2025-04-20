package com.edu.matriculasservice.client;

import com.edu.matriculasservice.model.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuarios-servicio")
public interface UsuarioFeignClient {

    @GetMapping("/usuarios/{id}")
    Usuario obtenerUsuarioPorId(@PathVariable("id") Long id);
}