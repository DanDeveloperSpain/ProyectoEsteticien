/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Cita;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ejb.Stateless;

/**
 *
 * @author DanielPerez
 */
@Stateless
public class CitaService implements CitaServiceLocal {
    private static ArrayList<Cita> lista = new ArrayList<>();
    private static int lastId = 3;
    
    static{
        lista.add(new Cita(1, 1, 3, "12/10/2016","12:00"));
        lista.add(new Cita(2, 2, 4, "11/11/2016","13:00"));
        
    }

    @Override
    public ArrayList listaCitas() {
        return lista;
    }

    @Override
    public void addCita(Cita cita) {
        // Recorremos la lista comprobando que la cita no existe
        Iterator<Cita> it = lista.iterator();
        boolean enc = false;
        
        while((it.hasNext())&&(enc==false)){
            if(it.next().getId()==cita.getId()){
                enc=true;
            }
        }
        // Si la cita no existe la añadimos a la lista
        if(enc==false){
            cita.setId(lastId);
            lastId++;
            lista.add(cita);
        }
    }
}
