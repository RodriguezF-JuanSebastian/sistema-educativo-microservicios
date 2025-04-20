package com.edu.asignaturas_servicio.service;

import com.edu.asignaturas_servicio.model.Asignatura;
import com.edu.asignaturas_servicio.repository.AsignaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Implementación AsignaturaServiceImpl (Cómo lo voy a hacer)
 * La implementación de la interfaz es donde realmente escribes la lógica de cada uno de los métodos
 */

@Service // Marca esta clase para que Spring la gestione como un servicio
public class AsignaturaServiceImpl implements AsignaturaService {

//Medotodos La implementación de la interfaz es donde realmente escribes la lógica de cada uno de los métodos
private final AsignaturaRepository asignaturaRepository;

// Constructor que recibe el repositorio para interactuar con la base de datos
public AsignaturaServiceImpl(AsignaturaRepository asignaturaRepository) {
    this.asignaturaRepository = asignaturaRepository;
}

@Override
public List<Asignatura> obtenerTodasAsignaturas() {
    return asignaturaRepository.findAll();  // Lógica para obtener todas las asignaturas de la base de datos
}

@Override
public Asignatura obtenerAsignaturaPorId(Long id) {
    return asignaturaRepository.findById(id).orElse(null);  // Lógica para obtener una asignatura por su ID
}

@Override
public Asignatura guardarAsignatura(Asignatura asignatura) {
    return asignaturaRepository.save(asignatura);  // Lógica para guardar una asignatura en la base de datos
}

@Override
public void eliminarAsignatura(Long id) {
    asignaturaRepository.deleteById(id);  // Lógica para eliminar una asignatura de la base de datos
}
}
