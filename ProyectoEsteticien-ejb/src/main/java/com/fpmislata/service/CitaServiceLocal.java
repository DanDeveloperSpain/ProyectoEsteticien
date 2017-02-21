/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Cita;
import com.fpmislata.domain.Cliente;
import com.fpmislata.domain.Tratamiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DanielPerez
 */
@Local
public interface CitaServiceLocal {

    List listCitas();
    
    void addCita(Cita cita);
    //void addCita(Cita cita, Cliente cliente, Tratamiento tratamiento);
    
    Cita findCitaById(Cita cita);
    
    void updateCita(Cita cita);
    
    void deleteCita(Cita cita);

    
}
