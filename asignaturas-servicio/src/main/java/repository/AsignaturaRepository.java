package com.edu.asignaturas_servicio.repository;

import com.edu.asignaturas_servicio.entity.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
}
