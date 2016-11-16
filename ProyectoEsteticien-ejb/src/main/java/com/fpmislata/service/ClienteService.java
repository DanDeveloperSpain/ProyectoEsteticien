/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Cliente;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author alumno
 */
@Stateless
public class ClienteService implements ClienteServiceLocal {
    
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
    private static int lastId = 6;
    
    static{
        listaClientes.add(new Cliente(1,"Vicente","Escamilla","33570997J","6710561859","viescam@outlook.es"));
        listaClientes.add(new Cliente(2,"Maria","Garcia","22334456Q","695874123","mariag@gmail.com"));
        listaClientes.add(new Cliente(3,"Carlos","Gonzalez","56781234R","659858471","carlogon@gmail.com"));
        listaClientes.add(new Cliente(4,"Ana","Ibañez","23564565P","629573049","ana@gmail.com"));
        listaClientes.add(new Cliente(5,"Alberto","Serrano","33565478K","696969636","aserr@gmail.es"));      
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public ArrayList<Cliente> listar() {
        return listaClientes;
    }
    
    @Override
    public Cliente mostrarUno(Cliente cliente) {
        Cliente clienteMostrar = null;
        for(int i=0;i<listaClientes.size();i++){
            if(listaClientes.get(i).getId()==cliente.getId()){
               clienteMostrar=listaClientes.get(i);
            }
        }
        return clienteMostrar;
                  
        
    }
    
    
    @Override
    public void borrar(Cliente cliente) {
        for(int i=0;i<listaClientes.size();i++){
            if(listaClientes.get(i).getId()==cliente.getId()){
               listaClientes.remove(listaClientes.get(i));
            }
        }
    }

    @Override
    public void agregar(Cliente cliente) {
        cliente.setId(lastId);
        listaClientes.add(cliente);
        lastId++;
    }

    @Override
    public void modificar(Cliente cliente) {
        int idCliente=cliente.getId();
        int posClienteModif=-1;
        for(int i=0;i<listaClientes.size();i++){
            if(listaClientes.get(i).getId()==idCliente){
                posClienteModif=i;
            }
        }
        if(posClienteModif!=-1){
            listaClientes.set(posClienteModif, cliente);
        }
    }

    

    
    
    
    
    
    
    
}
