package com.fcfm.backend.controller;

import com.fcfm.backend.model.alumno;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/alumno")
public interface AlumnoApiController {
    @GetMapping("/")
    ResponseEntity<List<alumno>> getAlumnoList();
    @GetMapping("/2/{}")
    ResponseEntity <String> prueba(@PathVariable int id);

    @GetMapping("/{idAlumno}")
    ResponseEntity<alumno> getAlumnobyId(@PathVariable int idAlumno);

    @PostMapping("/")
    ResponseEntity<alumno> createAlumno(@RequestBody alumno alumnonuevo);

    @PutMapping ("g/{idAlumno}")
    ResponseEntity<List<alumno>> updateAlumno(@PathVariable int idAlumno, @RequestBody alumno alumnoActualizado);

    @DeleteMapping ("g/{idAlumno}")
    ResponseEntity<List<alumno>> deleteAlumnobyId(@PathVariable int idAlumno);
}
