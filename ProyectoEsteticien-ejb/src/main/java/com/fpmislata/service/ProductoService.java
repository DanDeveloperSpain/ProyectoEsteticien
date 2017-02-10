/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Producto;
import com.fpmislata.repository.ProductoDaoLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Vicente
 */
@Stateless
public class ProductoService implements ProductoServiceLocal {
    
   @EJB
    private ProductoDaoLocal productoDao;

    @Override
    public List listaProductos() {
        return productoDao.listProducto();
    }
    
    

    @Override
    public void addProducto(Producto producto) {
        // Comprobamos que no existe por Id
            Producto p = productoDao.findProductoById(producto);
            if(p==null){
                productoDao.addProducto(producto);
            }
    }

    @Override
    public void updateProducto(Producto producto) {
        productoDao.updateProducto(producto); 
    }

    @Override
    public Producto findProductoById(Producto producto) {
        return productoDao.findProductoById(producto);
    }

    @Override
    public void deleteProducto(Producto producto) {
        productoDao.deleteProducto(producto);
    }
   
}
