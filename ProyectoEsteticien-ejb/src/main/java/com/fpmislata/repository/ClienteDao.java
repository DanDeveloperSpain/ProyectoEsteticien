/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author DanielPerez
 */
@Stateless
public class ClienteDao implements ClienteDaoLocal {

    @PersistenceContext(unitName = "EsteticienPU")
    EntityManager em;

    @Override
    public List listCliente() {
        List a = em.createNamedQuery("Cliente.findAll").getResultList();
        return a;
    }

    @Override
    public void addCliente(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        em.merge(cliente);
    }

    @Override
    public Cliente findClienteById(Cliente cliente) {
        return em.find(Cliente.class, cliente.getId());
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        cliente = findClienteById(cliente);
        em.remove(cliente);
    }
    
    @Override
    public List listClientesBySexo(String sexoP) {
        Query query = em.createNamedQuery("Cliente.findBySexo");
        query.setParameter("sexo",sexoP);
        List<Cliente> resultados = query.getResultList();
        return resultados;
    }
    
}
