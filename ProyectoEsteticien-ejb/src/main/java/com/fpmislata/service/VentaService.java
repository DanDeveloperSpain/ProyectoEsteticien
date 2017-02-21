/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Cliente;
import com.fpmislata.domain.Producto;
import com.fpmislata.domain.Venta;
import com.fpmislata.repository.ClienteDaoLocal;
import com.fpmislata.repository.ProductoDaoLocal;
import com.fpmislata.repository.VentaDaoLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Vicente
 */
@Stateless
public class VentaService implements VentaServiceLocal {

    @EJB
    private VentaDaoLocal ventaDao;

    @EJB
    private ProductoDaoLocal productoDao;
    
    @EJB
    private ClienteDaoLocal clienteDao;

    @Override
    public List listaVentas() {
        return ventaDao.listVenta();
    }
    
    @Override
    public void addVenta1(Venta venta) {
        // Comprobamos que no existe por Id
            Venta p = ventaDao.findVentaById(venta);
            if(p==null){
                ventaDao.addVenta(venta);
            }
    }

    @Override
    public void addVenta(Venta venta, Cliente cliente, ArrayList<Producto> idProductos) {
        // Comprobamos que no existe por Id
        Venta v = ventaDao.findVentaById(venta);
        if (v == null) {

            Double precioTotalVenta = 0.0;

            // Asignamos los valores de la venta al cliente
            
            Cliente cli = new Cliente();
            cli = clienteDao.findClienteById(cliente);
            
            venta.setCliente(cli);
            cli.getVentas().add(venta);

            for (int i = 0; i < idProductos.size(); i++) {
         
                //Recuperamos el objeto producto
                Producto prod = new Producto();
                prod = productoDao.findProductoById(idProductos.get(i));

                //Asignamos el producto a la venta y viceversa
                venta.getProductos().add(prod);
                prod.getVentas().add(venta);

                //Vamos sumando el precio final
                precioTotalVenta += prod.getPrecioProducto();

                //Actualizamos el producto con su venta asignadas
                try {
                    
                    productoDao.updateProducto(prod);

                } catch (Exception e) {
                    //Informamos cualquier error 
                    e.printStackTrace();
                }
            }

            venta.setPrecioTotal(precioTotalVenta);

            try {
                
                clienteDao.updateCliente(cli);
                ventaDao.addVenta(venta);
                
            } catch (Exception e) {
                //Informamos cualquier error 
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateVenta(Venta venta) {
        ventaDao.updateVenta(venta);
    }

    @Override
    public Venta findVentaById(Venta venta) {
        return ventaDao.findVentaById(venta);
    }

    @Override
    public void deleteVenta(Venta venta) {
        ventaDao.deleteVenta(venta);
    }

}
