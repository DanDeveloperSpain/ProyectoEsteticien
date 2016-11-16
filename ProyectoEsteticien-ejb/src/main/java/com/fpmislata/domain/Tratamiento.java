/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.domain;

import java.io.Serializable;

/**
 *
 * @author DanielPerez
 */
public class Tratamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String nombreTrat;
    private double precioTrat, duracionTrat;
    private int sala;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreTrat() {
        return nombreTrat;
    }

    public void setNombreTrat(String nombreTrat) {
        this.nombreTrat = nombreTrat;
    }
    
    public double getPrecioTrat() {
        return precioTrat;
    }

    public void setPrecioTrat(double precioTrat) {
        this.precioTrat = precioTrat;
    }
    
    public double getDuracionTrat() {
        return duracionTrat;
    }

    public void setDuracionTrat(double duracionTrat) {
        this.duracionTrat = duracionTrat;
    }
    
    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }
    
    public Tratamiento(){
        
    }
    
    public Tratamiento(int id, String nombreTrat, double precioTrat, double duracionTrat, int sala){
        this.id = id;
        this.nombreTrat = nombreTrat;
        this.precioTrat=precioTrat;
        this.duracionTrat=duracionTrat;
        this.sala=sala;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tratamiento other = (Tratamiento) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
   
}
