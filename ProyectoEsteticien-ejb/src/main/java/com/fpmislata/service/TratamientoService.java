/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;


import com.fpmislata.domain.Tratamiento;
import com.fpmislata.repository.TratamientoDaoLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author DanielPerez
 */
@Stateless
public class TratamientoService implements TratamientoServiceLocal {
    
    
    @EJB
    private TratamientoDaoLocal tratamientoDao;

    @Override
    public List listaTratamientos() {
        return tratamientoDao.listTratamiento();
    }
    
    

    @Override
    public void addTratamiento(Tratamiento tratamiento) {
        // Comprobamos que no existe por Id
            Tratamiento p = tratamientoDao.findTratamientoById(tratamiento);
            if(p==null){
                tratamientoDao.addTratamiento(tratamiento);
            }
    }

    @Override
    public void updateTratamiento(Tratamiento tratamiento) {
        tratamientoDao.updateTratamiento(tratamiento); 
    }

    @Override
    public Tratamiento findTratamientoById(Tratamiento tratamiento) {
        return tratamientoDao.findTratamientoById(tratamiento);
    }

    @Override
    public void deleteTratamiento(Tratamiento tratamiento) {
        tratamientoDao.deleteTratamiento(tratamiento);
    }

    /*@Override
    public Tratamiento mostrarUno(Tratamiento tratamiento) {
        return tratamientoDao.findTratamientoById(tratamiento);
        
    }

    @Override
    public Tratamiento muestraUnoId(int id) {
        Tratamiento tratamientoMostrar = null;
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getId()==id){
               tratamientoMostrar=lista.get(i);
            }
        }
        return tratamientoMostrar;
    }
    */
    
    
}
