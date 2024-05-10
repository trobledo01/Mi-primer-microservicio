package com.fcfm.backend.controller;

import com.fcfm.backend.model.alumno;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/alumno")
public interface AlumnoApiController {
    @GetMapping("/")
    ResponseEntity<List<alumno>> getAlumnoList(HttpServletRequest request);

    @GetMapping("/{idAlumno}")
    ResponseEntity<alumno> getAlumnobyId(HttpServletRequest request, @PathVariable Long idAlumno);

    @PostMapping("/")
    ResponseEntity<alumno> createAlumno(HttpServletRequest request, @RequestBody alumno alumnoNuevo);

    @PutMapping("/")
    ResponseEntity<alumno> updateAlumno(HttpServletRequest request, @RequestBody alumno alumnoNuevo);

    @DeleteMapping("/{idAlumno}")
    ResponseEntity<alumno> deleteAlumnobyId(HttpServletRequest request, @PathVariable int idAlumno);
}
