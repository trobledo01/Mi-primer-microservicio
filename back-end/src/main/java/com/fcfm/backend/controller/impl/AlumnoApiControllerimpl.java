package com.fcfm.backend.controller.impl;

import com.fcfm.backend.controller.AlumnoApiController;
import com.fcfm.backend.model.alumno;
import com.fcfm.backend.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlumnoApiControllerimpl  implements AlumnoApiController {
    private AlumnoService alumnoService;

    @Autowired
    AlumnoApiControllerimpl(AlumnoService alumnoService){
        this.alumnoService = alumnoService;

    }


    @Override
    public ResponseEntity<List<alumno>> getAlumnoList() {

        return ResponseEntity.ok().body(alumnoService.getAlumnoList());
    }

    @Override
    public ResponseEntity<String> prueba(int id) {
        return  ResponseEntity.ok().body(Integer.toString(id));
    }


    @Override
    public ResponseEntity<alumno> getAlumnobyId(@PathVariable int id) {
        return ResponseEntity.ok().body(alumnoService.getAlumnobyId(id));
    }

    @Override
    public ResponseEntity<alumno> createAlumno(@RequestBody alumno alumnonuevo) {
        alumnoService.createAlumno(alumnonuevo);
        return ResponseEntity.ok().body(alumnonuevo);
    }

    @Override
    public ResponseEntity<List<alumno>> updateAlumno(@PathVariable int id, @RequestBody alumno alumnoActualizado) {

        alumnoService.updateAlumno(id,alumnoActualizado);


        return ResponseEntity.ok().body(alumnoService.getAlumnoList());

    }

    @Override
    public ResponseEntity<List<alumno>> deleteAlumnobyId(int idAlumno) {
        alumnoService.deleteAlumbyId(idAlumno);
        return ResponseEntity.ok().body(alumnoService.getAlumnoList());

    }
}
