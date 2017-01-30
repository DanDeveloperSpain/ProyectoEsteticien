/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Tratamiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DanielPerez
 */
@Local
public interface TratamientoDaoLocal {
    
    List listTratamiento();

    void addTratamiento(Tratamiento tratamiento);

    void updateTratamiento(Tratamiento tratamiento);

    Tratamiento findTratamientoById(Tratamiento tratamiento);

    void deleteTratamiento(Tratamiento tratamiento);
    
}
