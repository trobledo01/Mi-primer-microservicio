package com.fcfm.backend.service;

import com.fcfm.backend.model.alumno;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoServiceimpl implements AlumnoService{
    List<alumno> alumnoList = new ArrayList<>();
    alumno alumno1 ;
    @Override
    public List <alumno> getAlumnoList() {
        return alumnoList;

    }

    @Override
    public void createAlumno(alumno alumNu) {
        alumnoList.add(alumNu);
    }

    @Override
    public alumno getAlumnobyId(int id) {
        return alumnoList.get(id);
    }
}
