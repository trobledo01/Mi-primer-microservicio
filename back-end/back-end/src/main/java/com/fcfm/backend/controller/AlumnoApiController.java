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
    ResponseEntity<alumno> getAlumnobyId(@PathVariable int id);

    @PostMapping("/")
    ResponseEntity<alumno> createAlumno(@RequestBody alumno alumnonuevo);
}
