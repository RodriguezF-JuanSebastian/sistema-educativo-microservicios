package com.edu.asignaturas_servicio.controller;

import com.edu.asignaturas_servicio.model.Asignatura;
import com.edu.asignaturas_servicio.service.AsignaturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Indica que esta clase es un controlador REST, que responderá con JSON por defecto.
@RequestMapping("/asignaturas") //Define la ruta base para todos los métodos dentro del controlador
public class AsignaturaController {

    private final AsignaturaService asignaturaService;


    public AsignaturaController(AsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }

    @GetMapping
    public List<Asignatura> obtenerTodasAsignaturas() {
        return asignaturaService.obtenerTodasAsignaturas();
    }

    @GetMapping("/{id}")
    public Asignatura obtenerAsignaturaPorId(@PathVariable Long id) {
        return asignaturaService.obtenerAsignaturaPorId(id);
    }

    @PostMapping
    public Asignatura guardarAsignatura(@RequestBody Asignatura asignatura) {
        return asignaturaService.guardarAsignatura(asignatura);
    }

    @DeleteMapping("/{id}")
    public void eliminarAsignatura(@PathVariable Long id) {
        asignaturaService.eliminarAsignatura(id);
    }
}