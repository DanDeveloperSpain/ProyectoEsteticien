/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Cita;
import com.fpmislata.domain.Cliente;
import com.fpmislata.domain.Tratamiento;
import com.fpmislata.repository.CitaDaoLocal;
import com.fpmislata.repository.ClienteDaoLocal;
import com.fpmislata.repository.TratamientoDaoLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author DanielPerez
 */
@Stateless
public class CitaService implements CitaServiceLocal {

    @EJB
    private CitaDaoLocal citaDao;

    @EJB
    private ClienteDaoLocal clienteDao;

    @EJB
    private TratamientoDaoLocal tratamientoDao;

    @Override
    public List listCitas() {
        return citaDao.listCitas();
    }

    @Override
    public void addCita(Cita cita, Cliente cliente, Tratamiento tratamiento) {

        //Recuperamos el cliente
        Cliente cli = new Cliente();
        cli = clienteDao.findClienteById(cliente);
        //Asignamos la cita al cliente y viceversa
        cita.setCliente(cli);
        cli.getCitas().add(cita);

        //Recuperamos el tratamieno
        Tratamiento trat = new Tratamiento();
        trat = tratamientoDao.findTratamientoById(tratamiento);
        //Asignamos la cita al tratamiento y viceversa
        cita.setTratamiento(trat);
        trat.getCitas().add(cita);

        try {

            clienteDao.updateCliente(cli);
            tratamientoDao.updateTratamiento(trat);

            citaDao.addCita(cita);

        } catch (Exception e) {
            //Informamos cualquier error 
            e.printStackTrace();
        }

    }

    @Override
    public Cita findCitaById(Cita cita) {
        return citaDao.findCitaById(cita);
    }

    @Override
    public void updateCita(Cita cita) {
        citaDao.updateCita(cita);
    }

    @Override
    public void deleteCita(Cita cita) {
        citaDao.deleteCita(cita);
    }
}
