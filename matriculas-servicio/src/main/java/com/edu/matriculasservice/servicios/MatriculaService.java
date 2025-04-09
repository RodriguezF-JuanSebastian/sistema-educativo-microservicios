package com.edu.matriculasservice.servicios;

import com.edu.matriculasservice.clientes.UsuarioClient;
import com.edu.matriculasservice.clientes.MatriculaUsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {

    @Autowired
    private UsuarioClient usuarioClient;

    public MatriculaUsuarioDTO obtenerDatosUsuario(Long idUsuario) {
        return usuarioClient.obtenerUsuarioPorId(idUsuario);
    }
}