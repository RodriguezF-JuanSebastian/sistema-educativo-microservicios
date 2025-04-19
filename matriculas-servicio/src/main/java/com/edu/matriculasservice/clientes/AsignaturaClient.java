package com.edu.matriculasservice.clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Se conecta al microservicio llamado "asignaturas-servicio" registrado en Eureka
@FeignClient(name = "asignaturas-servicio")
public interface AsignaturaClient {

    // Llama al endpoint /api/asignaturas/{id} del microservicio asignaturas-servicio
    @GetMapping("/asignaturas/{id}")
    MatriculaAsignaturaDTO obtenerAsignaturaPorId(@PathVariable("id") Long id);
}