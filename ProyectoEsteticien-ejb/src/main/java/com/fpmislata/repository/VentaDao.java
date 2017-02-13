/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Venta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DanielPerez
 */
@Stateless
public class VentaDao implements VentaDaoLocal {

    @PersistenceContext(unitName="EsteticienPU")
    EntityManager em;
    
    
    @Override
    public List listVenta() {
        List a = em.createNamedQuery("Venta.findAll").getResultList();
        return a;
    }
    
    @Override
    public void addVenta(Venta venta) {
        em.persist(venta);
    }

    @Override
    public void updateVenta(Venta venta) {
        em.merge(venta);
    }

    @Override
    public Venta findVentaById(Venta venta) {
        return em.find(Venta.class, venta.getId());
    }   

    @Override
    public void deleteVenta(Venta venta) {
        venta = findVentaById(venta);
        em.remove(venta);
    }
}
