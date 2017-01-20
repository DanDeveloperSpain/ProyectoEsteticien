/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.Cita;
import com.fpmislata.domain.Cliente;
import com.fpmislata.domain.Tratamiento;
import com.fpmislata.service.CitaServiceLocal;
import com.fpmislata.service.ClienteServiceLocal;
import com.fpmislata.service.TratamientoServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DanielPerez
 */
public class ListarCitas extends HttpServlet {

    @EJB
    private TratamientoServiceLocal tratamientoService;

    @EJB
    private ClienteServiceLocal clienteService;

    @EJB
    private CitaServiceLocal citaService;
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            // Ejecutamos el metodo y obtenemos la lista
            ArrayList<Cita> listaCita = citaService.listaCitas();
            ArrayList<Cliente> listaCli = new ArrayList<Cliente>();
            ArrayList<Tratamiento> listaTrat = new ArrayList<Tratamiento>();
            
            for(Cita cita : listaCita){
                Cliente cli = new Cliente(cita.getIdCliente(),"","","","","");
                Cliente cliente= clienteService.mostrarUno(cli);
                //Cliente cliente= clienteService.muestraUnoId(cita.getIdCliente());
                Tratamiento tra= new Tratamiento();
                tra.setId(cita.getIdTratamiento());
                //Tratamiento tratamiento= tratamientoService.muestraUnoId(cita.getIdTratamiento());
                listaCli.add(cliente);
                Tratamiento tratamiento= tratamientoService.mostrarUno(tra);
                listaTrat.add(tratamiento);
            }
               
            
            // Asignamos al request el atributo lista 
            request.getSession().setAttribute("citas",listaCita);
            request.getSession().setAttribute("clientes",listaCli);
            request.getSession().setAttribute("tratamientos",listaTrat);
            // Pasamos al RequestDispatcher la pagina a cargar
            RequestDispatcher rd = request.getRequestDispatcher("/listarCitas.jsp"); 
            // Cargamos la pagina
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
