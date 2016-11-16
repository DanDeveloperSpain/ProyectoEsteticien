/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.Tratamiento;
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
public class EliminarTratamiento extends HttpServlet {

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
        //1. Recuperamos los parametros
        String idTratamiento = request.getParameter("id");

        //2. Creamos el objeto Tratamiento
        int id = Integer.parseInt(idTratamiento);
        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setId(id);

        try {
            //3. Eliminamos el tratamiento
            this.tratamientoService.deleteTratamiento(tratamiento);
        } catch (Exception e) {
            //Informamos cualquier error
            e.printStackTrace();
        }

        // Ejecutamos el metodo y obtenemos la lista
        ArrayList lista = tratamientoService.listaTratamientos();
        // Asignamos al request el atributo lista
        request.getSession().setAttribute("tratamiento", lista);
        // Pasamos al RequestDispatcher la pagina a cargar
        RequestDispatcher rd = request.getRequestDispatcher("/listarTratamientos.jsp");
        // Cargamos la pagina
        rd.forward(request, response);
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
