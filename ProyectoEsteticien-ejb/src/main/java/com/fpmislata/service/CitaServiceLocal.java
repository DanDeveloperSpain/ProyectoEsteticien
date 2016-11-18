/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Cita;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author DanielPerez
 */
@Local
public interface CitaServiceLocal {

    ArrayList listaCitas();

    void addCita(Cita cita);

    
}
