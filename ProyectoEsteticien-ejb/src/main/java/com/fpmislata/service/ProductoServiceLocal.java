/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Producto;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Vicente
 */
@Local
public interface ProductoServiceLocal {

    ArrayList<Producto> listarProductos();
    
}
