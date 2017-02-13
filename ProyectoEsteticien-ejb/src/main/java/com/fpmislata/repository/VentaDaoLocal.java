/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Venta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DanielPerez
 */
@Local
public interface VentaDaoLocal {
    
    List listVenta();

    void addVenta(Venta venta);

    void updateVenta(Venta venta);

    Venta findVentaById(Venta venta);

    void deleteVenta(Venta venta);
    
}
