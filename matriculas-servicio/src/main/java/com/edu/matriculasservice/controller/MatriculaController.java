package com.edu.matriculasservice.controller;

import com.edu.matriculasservice.model.Matricula;
import com.edu.matriculasservice.service.MatriculaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping
    public List<Matricula> obtenerTodas() {
        return matriculaService.obtenerTodas();
    }

    @PostMapping
    public Matricula guardar(@RequestBody Matricula matricula) {
        return matriculaService.guardar(matricula);
    }

    @GetMapping("/{id}")
    public Matricula obtenerPorId(@PathVariable Long id) {
        return matriculaService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        matriculaService.eliminar(id);
    }
}