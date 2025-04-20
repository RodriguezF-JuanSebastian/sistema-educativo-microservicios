package com.edu.asignaturas_servicio.repository;

import com.edu.asignaturas_servicio.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
}