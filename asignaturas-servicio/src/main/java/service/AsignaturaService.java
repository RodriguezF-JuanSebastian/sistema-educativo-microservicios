package com.edu.asignaturas_servicio.service;

import com.edu.asignaturas_servicio.entity.Asignatura;

import java.util.List;
import java.util.Optional;

public interface AsignaturaService {
    List<Asignatura> obtenerTodas();
    Optional<Asignatura> obtenerPorId(Long id);
    Asignatura guardar(Asignatura asignatura);
    void eliminar(Long id);
}
