package com.fcfm.backend.repository.entity;

import jakarta.transaction.Transactional;

public interface AlumnoRepository {

    void  insertar(Alumno alumno);

    Alumno getAlumnoById(Long id);

    public void actualizar(Alumno alumno);

    // Método para borrar un alumno

    public void borrar(Long id) ;
}
