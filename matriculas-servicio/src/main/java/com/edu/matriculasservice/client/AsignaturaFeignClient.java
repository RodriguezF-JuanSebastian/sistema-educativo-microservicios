package com.edu.matriculasservice.client;

import com.edu.matriculasservice.model.Asignatura;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "asignaturas-servicio")
public interface AsignaturaFeignClient {

    @GetMapping("/asignaturas/{id}")
    Asignatura obtenerAsignaturaPorId(@PathVariable("id") Long id);
}

