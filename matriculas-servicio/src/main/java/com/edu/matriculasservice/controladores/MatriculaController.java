package com.edu.matriculasservice.controladores;

import com.edu.matriculasservice.entidades.Matricula;
import com.edu.matriculasservice.servicios.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.edu.matriculasservice.dto.MatriculaUsuarioDTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @PostMapping
    public Matricula guardar(@RequestBody Matricula matricula) {
        return matriculaService.guardar(matricula);
    }

    @GetMapping
    public List<Matricula> obtenerTodas() {
        return matriculaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Optional<Matricula> obtenerPorId(@PathVariable Long id) {
        return matriculaService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        matriculaService.eliminar(id);
    }

    @PutMapping("/{id}")
    public Matricula actualizar(@PathVariable Long id, @RequestBody Matricula matricula) {
        matricula.setId(id);
        return matriculaService.actualizar(matricula);
    }
    @GetMapping("/{id}/usuario")
    public MatriculaUsuarioDTO obtenerUsuarioDeMatricula(@PathVariable Long id) {
        return matriculaService.obtenerUsuarioDeMatricula(id);
    }

}
