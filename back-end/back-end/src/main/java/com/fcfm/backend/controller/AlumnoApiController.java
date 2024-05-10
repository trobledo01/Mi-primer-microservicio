package com.fcfm.backend.controller;

import com.fcfm.backend.model.alumno;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/alumno")
public interface AlumnoApiController {
    @GetMapping("/")
    ResponseEntity<List<alumno>> getAlumnoList();


    @GetMapping("/{idAlumno}")
    ResponseEntity<alumno> getAlumnobyId(@PathVariable Long idAlumno);

    @PostMapping("/")
    ResponseEntity<alumno> createAlumno(@RequestBody alumno alumnonuevo);

    @PutMapping("/")
    ResponseEntity<alumno> updateAlumno(@RequestBody alumno alumnonuevo);

    @DeleteMapping("/{idAlumno}")
    ResponseEntity<alumno> deleteAlumnobyId(@PathVariable int idAlumno);
}
