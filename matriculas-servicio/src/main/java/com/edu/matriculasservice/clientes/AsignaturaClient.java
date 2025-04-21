package com.edu.matriculasservice.clientes;

import com.edu.matriculasservice.dto.MatriculaAsignaturaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "asignaturas-servicio", url = "http://localhost:8081/api")
public interface AsignaturaClient {
    @GetMapping("/asignaturas/{id}")
    MatriculaAsignaturaDTO getAsignatura(@PathVariable("id") Long id);
}

