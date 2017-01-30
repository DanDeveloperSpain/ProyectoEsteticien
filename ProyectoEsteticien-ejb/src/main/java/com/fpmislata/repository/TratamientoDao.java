/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Tratamiento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DanielPerez
 */
@Stateless
public class TratamientoDao implements TratamientoDaoLocal {

    @PersistenceContext(unitName="EsteticienPU")
    EntityManager em;
    
    
    @Override
    public List listTratamiento() {
        List a = em.createNamedQuery("Tratamiento.findAll").getResultList();
        return a;
    }
    
    @Override
    public void addTratamiento(Tratamiento tratamiento) {
        em.persist(tratamiento);
    }

    @Override
    public void updateTratamiento(Tratamiento tratamiento) {
        em.merge(tratamiento);
    }

    @Override
    public Tratamiento findTratamientoById(Tratamiento tratamiento) {
        return em.find(Tratamiento.class, tratamiento.getId());
    }   

    @Override
    public void deleteTratamiento(Tratamiento tratamiento) {
        tratamiento = findTratamientoById(tratamiento);
        em.remove(tratamiento);
    }
}
