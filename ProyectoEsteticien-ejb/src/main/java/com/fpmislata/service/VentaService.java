/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Venta;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author Vicente
 */
@Stateless
public class VentaService implements VentaServiceLocal {
    private static ArrayList<Venta> listaVentas = new ArrayList<>();
    private static int lastId = 1;

    @Override
    public void agregarVenta(Venta venta) {
        venta.setIdVenta(lastId);
        listaVentas.add(venta);
        lastId++;        
    }
    
    @Override
    public ArrayList<Venta> listarVentas() {
        return listaVentas;
    }

    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    
}
