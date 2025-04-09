package com.edu.matriculasservice.controladores;

import com.edu.matriculasservice.clientes.MatriculaUsuarioDTO;
import com.edu.matriculasservice.servicios.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping("/usuario/{id}")
    public MatriculaUsuarioDTO obtenerUsuario(@PathVariable Long id) {
        return matriculaService.obtenerDatosUsuario(id);
    }
}
