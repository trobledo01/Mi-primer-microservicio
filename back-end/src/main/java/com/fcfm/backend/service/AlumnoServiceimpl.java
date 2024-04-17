package com.fcfm.backend.service;

import com.fcfm.backend.model.alumno;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoServiceimpl implements AlumnoService{
    public List<alumno> alumnoList = new ArrayList<>();

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

        return alumnoList.get((id));
    }

    @Override
    public void updateAlumno(int id, alumno alumnoActualizado) {
        alumnoList.set(id,alumnoActualizado);

    }

    @Override
    public void deleteAlumbyId(int id) {
        alumnoList.remove(id);

    }


}
