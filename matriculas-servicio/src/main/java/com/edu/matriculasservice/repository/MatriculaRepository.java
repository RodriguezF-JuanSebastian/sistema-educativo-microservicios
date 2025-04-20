package com.edu.matriculasservice.repository;

import com.edu.matriculasservice.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}