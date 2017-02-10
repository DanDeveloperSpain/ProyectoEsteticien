/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Cita;
import com.fpmislata.repository.CitaDaoLocal; 
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author DanielPerez
 */
@Stateless
public class CitaService implements CitaServiceLocal {
    
    @EJB
    private CitaDaoLocal citaDao;

    @Override
    public List listCitas() {
        return citaDao.listCitas();
    }

    @Override
    public void addCita(Cita cita) {
        citaDao.addCita(cita);
    }

    @Override
    public Cita findCitaById(Cita cita) {
        return citaDao.findCitaById(cita);
    }

    @Override
    public void updateCita(Cita cita) {
        citaDao.updateCita(cita);
    }

    @Override
    public void deleteCita(Cita cita) {
        citaDao.deleteCita(cita);
    }
}
