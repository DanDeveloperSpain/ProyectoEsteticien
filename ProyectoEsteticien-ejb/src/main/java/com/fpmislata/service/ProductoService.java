/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Cliente;
import com.fpmislata.domain.Producto;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author Vicente
 */
@Stateless
public class ProductoService implements ProductoServiceLocal {
    
    private static ArrayList<Producto> listaProductos = new ArrayList<>();
    private static int lastId = 6;
    
    static{
        listaProductos.add(new Producto(1,"Aceite esencia de té","aceites de masaje",4.95));
        listaProductos.add(new Producto(2,"Crema reafirmante Skin Clinic","cremas",19.90));
        listaProductos.add(new Producto(3,"Sérum reparador Shu Uemura 30ml","cremas",30.45));
        listaProductos.add(new Producto(4,"Champú revitalizante L'Oreal","champus",13.45));
        listaProductos.add(new Producto(5,"After Save Eucerin 75ml","afeitado",12.63));
        listaProductos.add(new Producto(6,"Avene men espuma de afeitado 200 ml","afeitado",9.74));
        
    }
    
     @Override
    public ArrayList<Producto> listarProductos() {
        return listaProductos;
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Producto mostrarUno(Producto prod) {
        Producto prodMostrar = null;
        for(int i=0;i<listaProductos.size();i++){
            if(listaProductos.get(i).getId()==prod.getId()){
               prodMostrar=listaProductos.get(i);
            }
        }
        return prodMostrar;
    }

   
}
