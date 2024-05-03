package com.fcfm.backend.service;

import com.fcfm.backend.model.alumno;
import com.fcfm.backend.repository.entity.Alumno;
import com.fcfm.backend.repository.entity.AlumnoRepository;
import com.fcfm.backend.utils.AlumnoMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoServiceimpl implements AlumnoService{
    public List<alumno> alumnoList = new ArrayList<>();
    private AlumnoRepository alumnoRepository;
    @Override
    public List <alumno> getAlumnoList() {
        return alumnoList;

    }

    @Override
    public void createAlumno(alumno alumNu) {
        com.fcfm.backend.repository.entity.Alumno alumno = new Alumno();
        alumno.setPrimerNombre(alumNu.getPrimerNombre());
        alumno.setSegundoNombre(alumNu.getSegundoNombre());
        alumno.setApellidoPat(alumNu.getApellidoPat());
        alumno.setApellidoMat(alumNu.getApellidoMat());
        alumno.setCurp(alumno.getCurp());
        alumno.setEmail(alumNu.getEmail());
        alumno.setFechaNac(alumNu.getFechaNac());

        alumnoRepository.insertar(AlumnoMapper.alumnoModeltoEntity(alumNu));
    }

    @Override
    public alumno getAlumnobyId(Long id) {
        com.fcfm.backend.repository.entity.Alumno alumnoEntity = alumnoRepository.getAlumnoById(Long.valueOf(id));

            return AlumnoMapper.alumnoEntityToAlumno(alumnoEntity);
        }



    @Override
    public void updateAlumno(alumno alumNu) {
        com.fcfm.backend.repository.entity.Alumno alumno = new Alumno();
        alumno.setPrimerNombre(alumNu.getPrimerNombre());
        alumno.setSegundoNombre(alumNu.getSegundoNombre());
        alumno.setApellidoPat(alumNu.getApellidoPat());
        alumno.setApellidoMat(alumNu.getApellidoMat());
        alumno.setCurp(alumno.getCurp());
        alumno.setEmail(alumNu.getEmail());
        alumno.setFechaNac(alumNu.getFechaNac());

        alumnoRepository.actualizar(alumno);
    }

    @Override
    public void deleteAlumno(Long id) {
        alumnoRepository.borrar(id);
    }
}







