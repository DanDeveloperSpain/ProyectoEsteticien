/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Cliente;
import com.fpmislata.domain.Producto;
import com.fpmislata.domain.Venta;
import com.fpmislata.domain.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Vicente
 */
@Local
public interface VentaServiceLocal {

    List listaVentas();
    
    void addVenta1(Venta venta);
    
    void addVenta(Venta venta, Cliente cliente, ArrayList<Producto> productosVendidos);
    
    void updateVenta(Venta venta);

    Venta findVentaById(Venta venta);

    void deleteVenta(Venta venta);
    
}
