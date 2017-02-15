/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author alumno
 */
@Local
public interface ClienteServiceLocal {

    void borrar(Cliente cliente);

    void agregar(Cliente cliente);

    void modificar(Cliente cliente);

    List listarClientes();

    Cliente mostrarUno(Cliente cliente);
    
    List listClientesBySexo(String sexoP);

    //Cliente muestraUnoId(int id);
    
}
