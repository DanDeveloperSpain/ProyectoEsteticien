/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Cita;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DanielPerez
 */
@Local
public interface CitaDaoLocal {
    
    List listCitas();

    void addCita(Cita cita);

    void updateCita(Cita cita);

    Cita findCitaById(Cita cita);

    void deleteCita(Cita cita);
    
}
