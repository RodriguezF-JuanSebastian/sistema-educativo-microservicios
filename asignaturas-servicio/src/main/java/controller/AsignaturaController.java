package com.edu.asignaturas_servicio.controller;

import com.edu.asignaturas_servicio.entity.Asignatura;
import com.edu.asignaturas_servicio.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping
    public List<Asignatura> obtenerTodas() {
        return asignaturaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Optional<Asignatura> obtenerPorId(@PathVariable Long id) {
        return asignaturaService.obtenerPorId(id);
    }

    @PostMapping
    public Asignatura guardar(@RequestBody Asignatura asignatura) {
        return asignaturaService.guardar(asignatura);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        asignaturaService.eliminar(id);
    }
}
