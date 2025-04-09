package com.edu.asignaturas_servicio.service.impl;

import com.edu.asignaturas_servicio.entity.Asignatura;
import com.edu.asignaturas_servicio.repository.AsignaturaRepository;
import com.edu.asignaturas_servicio.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Override
    public List<Asignatura> obtenerTodas() {
        return asignaturaRepository.findAll();
    }

    @Override
    public Optional<Asignatura> obtenerPorId(Long id) {
        return asignaturaRepository.findById(id);
    }

    @Override
    public Asignatura guardar(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public void eliminar(Long id) {
        asignaturaRepository.deleteById(id);
    }
}
