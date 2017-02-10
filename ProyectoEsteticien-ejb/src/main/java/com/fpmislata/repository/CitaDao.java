/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Cita;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DanielPerez
 */
@Stateless
public class CitaDao implements CitaDaoLocal {

    @PersistenceContext(unitName="CitaPU")
    EntityManager em;
    
    
    @Override
    public List listCitas() {
        List a = em.createNamedQuery("Cita.findAll").getResultList();
        return a;
    }
    
    @Override
    public void addCita(Cita cita) {
        em.persist(cita);
    }

    @Override
    public void updateCita(Cita cita) {
        em.merge(cita);
    }

    @Override
    public Cita findCitaById(Cita cita) {
        return em.find(Cita.class, cita.getId());
    }   

    @Override
    public void deleteCita(Cita cita) {
        cita = findCitaById(cita);
        em.remove(cita);
    }
}
