package com.fcfm.backend.service;

import com.fcfm.backend.model.alumno;

import java.util.List;

public interface AlumnoService {

    List<alumno> getAlumnoList();

    public void createAlumno(alumno alumNu);

    alumno getAlumnobyId(Long id);


    public void updateAlumno(alumno alumNu);

    public void deleteAlumno(Long id);

}
