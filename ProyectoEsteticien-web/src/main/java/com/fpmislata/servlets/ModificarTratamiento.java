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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DanielPerez
 */
public class ModificarTratamiento extends HttpServlet {

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
        
        String accion = request.getParameter("accion");

        if (accion != null && accion.equals("editar")) {
            
            //1. Recuperamos el id del tratamiento seleccionado
            String idTratamiento = request.getParameter("id");
            if (idTratamiento != null) {
                //2. Creamos el objeto tratamiento a recuperar
                int id = Integer.valueOf(idTratamiento);
                Tratamiento tratamiento = new Tratamiento();
                tratamiento.setId(id);
                try{              
                    tratamiento = this.tratamientoService.findTratamientoById(tratamiento);
                }catch(Exception e){
                    e.printStackTrace();
                }

                //3. Compartimos el objeto tratamiento en alcance request
                request.setAttribute("tratamiento", tratamiento);

                //4. Redireccionamos a la pagina para editar el objeto Tratamiento
                request.getRequestDispatcher("/modificarTratamiento.jsp").forward(request, response);
            }
        }else if  (accion != null && accion.equals("modificar")) {      

            //1. Recuperamos los parametros
            String idTratamiento = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            double precio = Double.parseDouble(request.getParameter("precio"));
            double duracion = Double.parseDouble(request.getParameter("duracion"));
            int sala = Integer.parseInt(request.getParameter("sala"));

            //2. Creamos el objeto Tratamiento
            Tratamiento tratamiento = new Tratamiento();
            int id = Integer.parseInt(idTratamiento);
            tratamiento.setId(id);
            tratamiento.setNombreTrat(nombre);
            tratamiento.setPrecioTrat(precio);
            tratamiento.setDuracionTrat(duracion);
            tratamiento.setSala(sala);

            try {
                this.tratamientoService.updateTratamiento(tratamiento);
            } catch (Exception e) {
                //Informamos cualquier error
                e.printStackTrace();
            }

            // Volvemos a cargar la lista de personas
            ArrayList<Tratamiento> lista = tratamientoService.listaTratamientos();
            request.setAttribute("tratamientos", lista);

            request.getRequestDispatcher("/listarTratamientos.jsp").forward(request, response);
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
