package com.fcfm.backend.utils;

import com.fcfm.backend.model.alumno;
import com.fcfm.backend.repository.entity.Alumno;

import java.sql.Date;

public class AlumnoMapper {

    public  static com.fcfm.backend.model.alumno alumnoEntityToAlumno(Alumno alumno){
        com.fcfm.backend.model.alumno model = new com.fcfm.backend.model.alumno();
        model.setPrimerNombre(alumno.getPrimerNombre());
        model.setSegundoNombre(alumno.getSegundoNombre());
        model.setApellidoPat(alumno.getApellidoPat());
        model.setApellidoMat(alumno.getApellidoMat());
        model.setFechaNac(Date.valueOf(alumno.getFechaNac().toString()));
        model.setCurp(alumno.getCurp());
        model.setEmail(alumno.getEmail());

        return  model;
    }

    public static com.fcfm.backend.repository.entity.Alumno alumnoModeltoEntity(com.fcfm.backend.model.alumno alumnoM){
        Alumno entity = new com.fcfm.backend.repository.entity.Alumno();
        entity.setPrimerNombre(alumnoM.getPrimerNombre());
        entity.setSegundoNombre(alumnoM.getSegundoNombre());
        entity.setApellidoPat(alumnoM.getApellidoPat());
        entity.setApellidoMat(alumnoM.getApellidoMat());
        entity.setFechaNac(Date.valueOf(alumnoM.getFechaNac().toString()));
        entity.setCurp(alumnoM.getCurp());
        entity.setEmail(alumnoM.getEmail());

        return entity;
    }
}
