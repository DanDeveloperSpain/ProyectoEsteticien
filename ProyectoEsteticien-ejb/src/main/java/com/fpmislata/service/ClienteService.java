/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Cliente;
import com.fpmislata.repository.ClienteDaoLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ClienteService implements ClienteServiceLocal {
    
    @EJB
    private ClienteDaoLocal clienteDao;
   

    @Override
    public List listarClientes() {
        return clienteDao.listCliente();
    }
    
    @Override
    public Cliente mostrarUno(Cliente cliente) {
        return clienteDao.findClienteById(cliente);
    }
    
    
    @Override
    public void borrar(Cliente cliente) {
        clienteDao.deleteCliente(cliente);
    }

    @Override
    public void agregar(Cliente cliente) {
        // Comprobamos que no existe por Id
            Cliente p = clienteDao.findClienteById(cliente);
            if(p==null){
                clienteDao.addCliente(cliente);
            }
    }

    @Override
    public void modificar(Cliente cliente) {
        clienteDao.updateCliente(cliente);
    }
    
    
    @Override
    public List listClientesBySexo(String sexoP) {
        return clienteDao.listClientesBySexo(sexoP);
    }

    /*@Override
    public Cliente muestraUnoId(int id) {
        Cliente clienteMostrar = null;
        for(int i=0;i<listaClientes.size();i++){
            if(listaClientes.get(i).getId()==id){
               clienteMostrar=listaClientes.get(i);
            }
        }
        return clienteMostrar;
    } 
    */
    
    
}
