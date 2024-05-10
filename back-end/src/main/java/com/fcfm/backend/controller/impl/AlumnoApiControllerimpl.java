package com.fcfm.backend.controller.impl;

import com.fcfm.backend.controller.AlumnoApiController;
import com.fcfm.backend.model.alumno;
import com.fcfm.backend.service.AlumnoService;
import com.fcfm.backend.authentication.JWTUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlumnoApiControllerImpl implements AlumnoApiController {

    private final AlumnoService alumnoService;
    private final JWTUtils jwtUtils;
    private final UserDetailsService userDetailsService;

    @Autowired
    public AlumnoApiControllerImpl(AlumnoService alumnoService, JWTUtils jwtUtils, UserDetailsService userDetailsService) {
        this.alumnoService = alumnoService;
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public ResponseEntity<List<alumno>> getAlumnoList(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null && !token.isBlank() && token.startsWith("Bearer ")) {
            token = token.substring(7);
            UserDetails userDetails = userDetailsService.loadUserByUsername(getUsernameFromToken(token));
            if (jwtUtils.validateToken(token, userDetails)) {
                return ResponseEntity.ok().body(alumnoService.getAlumnoList());
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @Override
    public ResponseEntity<alumno> getAlumnobyId(HttpServletRequest request, @PathVariable Long id) {
        String token = request.getHeader("Authorization");
        if (token != null && !token.isBlank() && token.startsWith("Bearer ")) {
            token = token.substring(7);
            UserDetails userDetails = userDetailsService.loadUserByUsername(getUsernameFromToken(token));
            if (jwtUtils.validateToken(token, userDetails)) {
                return ResponseEntity.ok().body(alumnoService.getAlumnobyId(id));
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @Override
    public ResponseEntity<alumno> createAlumno(HttpServletRequest request, @RequestBody alumno alumnoNuevo) {
        String token = request.getHeader("Authorization");
        if (token != null && !token.isBlank() && token.startsWith("Bearer ")) {
            token = token.substring(7);
            UserDetails userDetails = userDetailsService.loadUserByUsername(getUsernameFromToken(token));
            if (jwtUtils.validateToken(token, userDetails)) {
                alumnoService.createAlumno(alumnoNuevo);
                return ResponseEntity.ok().body(alumnoNuevo);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @Override
    public ResponseEntity<alumno> updateAlumno(HttpServletRequest request, @RequestBody alumno alumnoNuevo) {
        String token = request.getHeader("Authorization");
        if (token != null && !token.isBlank() && token.startsWith("Bearer ")) {
            token = token.substring(7);
            UserDetails userDetails = userDetailsService.loadUserByUsername(getUsernameFromToken(token));
            if (jwtUtils.validateToken(token, userDetails)) {
                alumnoService.updateAlumno(alumnoNuevo);
                return ResponseEntity.ok().body(alumnoNuevo);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @Override
    public ResponseEntity<alumno> deleteAlumnobyId(HttpServletRequest request, @PathVariable int idAlumno) {
        String token = request.getHeader("Authorization");
        if (token != null && !token.isBlank() && token.startsWith("Bearer ")) {
            token = token.substring(7);
            UserDetails userDetails = userDetailsService.loadUserByUsername(getUsernameFromToken(token));
            if (jwtUtils.validateToken(token, userDetails)) {
                alumnoService.deleteAlumno((long) idAlumno);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    private String getUsernameFromToken(String token) {
        return jwtUtils.extractUsername(token);
    }
}
