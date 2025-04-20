package com.edu.matriculasservice.service;

import com.edu.matriculasservice.client.UsuarioFeignClient;
import com.edu.matriculasservice.model.Matricula;
import com.edu.matriculasservice.model.Usuario;
import com.edu.matriculasservice.repository.MatriculaRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final UsuarioFeignClient usuarioFeignClient;


    public MatriculaServiceImpl(MatriculaRepository matriculaRepository,
                                UsuarioFeignClient usuarioFeignClient) {
        this.matriculaRepository = matriculaRepository;
        this.usuarioFeignClient = usuarioFeignClient;
    }

        @Override
    public void registrarMatricula(Long usuarioId) {
        Usuario usuario = usuarioFeignClient.obtenerUsuarioPorId(usuarioId);
        System.out.println("Usuario: " + usuario.getNombre());
        // lógica de matrícula
    }

    @Override
    public List<Matricula> obtenerTodas() {
        return matriculaRepository.findAll();
    }

    @Override
    public Matricula guardar(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula obtenerPorId(Long id) {
        return matriculaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        matriculaRepository.deleteById(id);
    }
}
