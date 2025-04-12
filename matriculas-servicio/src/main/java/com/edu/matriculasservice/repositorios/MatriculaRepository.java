package com.edu.matriculasservice.repositorios;

import com.edu.matriculasservice.entidades.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

}
