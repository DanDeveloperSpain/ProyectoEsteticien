/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Tratamiento;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ejb.Stateless;


/**
 *
 * @author DanielPerez
 */
@Stateless
public class TratamientoService implements TratamientoServiceLocal {
    private static ArrayList<Tratamiento> lista = new ArrayList<>();
    private static int lastId = 6;
    
    static{
        lista.add(new Tratamiento(1,"Depilacion Piernas",18.50, 0.45, 1));
        lista.add(new Tratamiento(2,"Depilacion Cejas",9.50, 0.30, 2));
        lista.add(new Tratamiento(3,"Depilacion Brazos",10.50, 0.40, 1));
        lista.add(new Tratamiento(4,"Tratamiento Uñas",11.50, 0.35, 2));
        lista.add(new Tratamiento(5,"Bronceado completo",25.50, 1.20, 3));
        
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public ArrayList listaTratamientos() {
        return lista;
    }
    
    

    @Override
    public void addTratamiento(Tratamiento tratamiento) {
        // Recorremos la lista comprobando que el tratamiento no existe
        Iterator<Tratamiento> it = lista.iterator();
        boolean enc = false;
        
        while((it.hasNext())&&(enc==false)){
            if(it.next().getId()==tratamiento.getId()){
                enc=true;
            }
        }
        // Si el tratamiento no existe la añadimos a la lista
        if(enc==false){
            tratamiento.setId(lastId);
            lastId++;
            lista.add(tratamiento);
        }
    }

    @Override
    public void updateTratamiento(Tratamiento tratamiento) {
        // Recorremos la lista comprobando que el tratamiento no existe
        boolean enc = false;
        int i=0;
        
        while((i<lista.size())&&(enc==false)){
            if(lista.get(i).getId()==tratamiento.getId()){
                enc=true;                
            }else{
                i++;
            }
        }
        // Si el tratamiento existe, tenemos el indice a modificar 
        // por lo que realizamos la actualizacion
        if(enc==true){
            lista.set(i, tratamiento);
        }    
    }

    @Override
    public Tratamiento findTratamientoById(Tratamiento tratamiento) {
        // Recorremos la lista buscando el tratamiento
        Iterator<Tratamiento> it = lista.iterator();
        
        while(it.hasNext()){
            Tratamiento p = it.next();
            if(p.getId()==tratamiento.getId()){
                return p;
            }
        }
        return null;
    }

    @Override
    public void deleteTratamiento(Tratamiento tratamiento) {
        // Recorremos la lista buscando el tratamiento
        boolean enc = false;
        int i=0;
        
        while((i<lista.size())&&(enc==false)){
            if(lista.get(i).getId()==tratamiento.getId()){
                enc=true;                
            }else{
                i++;
            }
        }
        // Si el tratamiento existe, tenemos el indice borrar
        if(enc==true){
            lista.remove(i);
        }
    }

    @Override
    public Tratamiento mostrarUno(Tratamiento tratamiento) {
        boolean enc = false;
        int i=0;
        
        while((i<lista.size())&&(enc==false)){
            if(lista.get(i).getId()==tratamiento.getId()){
                enc=true;                
            }else{
                i++;
            }
        }
        // Si el tratamiento existe, tenemos el indice borrar
        return lista.get(i);
        
    }
    
    
    
}
