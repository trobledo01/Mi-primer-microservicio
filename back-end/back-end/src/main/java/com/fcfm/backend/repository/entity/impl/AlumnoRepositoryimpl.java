package com.fcfm.backend.repository.entity.impl;

import com.fcfm.backend.repository.entity.Alumno;
import com.fcfm.backend.repository.entity.AlumnoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class AlumnoRepositoryimpl implements AlumnoRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void insertar(Alumno alumno){em.persist(alumno);}

    @Override
    public Alumno getAlumnoById(Long id){
        return  em.find(Alumno.class, id);
    }

    @Transactional
    public void actualizar(Alumno alumno) {
        em.merge(alumno);
    }

    // Método para borrar un alumno
    @Transactional
    public void borrar(Long id) {
        Alumno alumno = em.find(Alumno.class, id);
        if (alumno != null) {
            em.remove(alumno);
        }
    }

}
