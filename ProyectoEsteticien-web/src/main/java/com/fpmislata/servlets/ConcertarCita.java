/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.Cita;
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
public class ConcertarCita extends HttpServlet {

    @EJB
    private CitaServiceLocal citaService;

    @EJB
    private ClienteServiceLocal clienteService;

    @EJB
    private TratamientoServiceLocal tratamientoService;
    
    

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

        String accion = request.getParameter("accion");

        if (accion.equals("primero")) {

            try {
                // Ejecutamos el metodo y obtenemos la lista de clientes y tratamientos
                ArrayList listaCli = clienteService.listar();
                ArrayList listaTrat = tratamientoService.listaTratamientos();
                // Asignamos al request el atributo lista 
                request.getSession().setAttribute("listaCli", listaCli);
                request.getSession().setAttribute("listaTrat", listaTrat);
                // Pasamos al RequestDispatcher la pagina a cargar
                RequestDispatcher rd = request.getRequestDispatcher("/seleccionCita.jsp");
                // Cargamos la pagina
                rd.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (accion.equals("segundo")) {

            //Recogemos los datos para crear la cita
            int idCli = Integer.parseInt(request.getParameter("clienteChecked"));
            int idTrat = Integer.parseInt(request.getParameter("tratamientoChecked"));
            String dia = request.getParameter("dia");
            String hora = request.getParameter("hora");

            //2. Creamos el objeto Cita
            Cita cita = new Cita();
            cita.setIdCliente(idCli);
            cita.setIdTratamiento(idTrat);
            cita.setFecha(dia);
            cita.setHora(hora);

            try {
                citaService.addCita(cita);
            } catch (Exception e) {
                //Informamos cualquier error
                e.printStackTrace();
            }

            // Pasamos al RequestDispatcher la pagina a cargar
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            // Cargamos la pagina
            rd.forward(request, response);

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
