package com.edu.asignaturas_servicio.service;

import com.edu.asignaturas_servicio.model.Asignatura;
import java.util.List;

/* Interfaz AsignaturaService (Lo que quiero hacer)
* La interfaz define qué acciones o métodos deben estar disponibles en la implementación
*/
public interface AsignaturaService {

    List<Asignatura> obtenerTodasAsignaturas();
    Asignatura obtenerAsignaturaPorId(Long id);
    Asignatura guardarAsignatura(Asignatura asignatura);
    void eliminarAsignatura(Long id);
}
