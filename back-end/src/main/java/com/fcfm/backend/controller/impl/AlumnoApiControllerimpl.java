package com.fcfm.backend.controller.impl;

import com.fcfm.backend.controller.AlumnoApiController;
import com.fcfm.backend.model.alumno;
import com.fcfm.backend.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<alumno> getAlumnobyId(@PathVariable int id) {
        return ResponseEntity.ok().body(alumnoService.getAlumnobyId(id));
    }

    @Override
    public ResponseEntity<alumno> createAlumno(@RequestBody alumno alumnonuevo) {
        alumnoService.createAlumno(alumnonuevo);
        return ResponseEntity.ok().body(alumnonuevo);
    }
}
