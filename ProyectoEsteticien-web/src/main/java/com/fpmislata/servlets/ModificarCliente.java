/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.Cliente;
import com.fpmislata.service.ClienteServiceLocal;
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
 * @author alumno
 */
public class ModificarCliente extends HttpServlet {

    @EJB
    private ClienteServiceLocal clienteService;

    
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
        ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) request.getSession().getAttribute("listaClientes");
        
        String accion = request.getParameter("accion");
        if(accion.equals("cambiarDatos")){
            String[] clientesMarcados = request.getParameterValues("clienteChecked");
            if(clientesMarcados !=null){
                ArrayList<Cliente> clientesAModificar = new ArrayList<Cliente>();
                for(int i=0;i<clientesMarcados.length;i++){
                    int idClienteMarcado = Integer.parseInt(clientesMarcados[i]);
                    for(int j=0;j<listaClientes.size();j++){
                        if(listaClientes.get(j).getId()==idClienteMarcado){
                            clientesAModificar.add(listaClientes.get(j));
                        }
                    }
                }
                request.setAttribute("clientesModificar",clientesAModificar);
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/modificarCliente.jsp");
                rd.forward(request, response);
            }else{
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/listarClientes.jsp");
                rd.forward(request, response);
            }
        }
        if(accion.equals("confirmarModif")){
            String[] idModificar = request.getParameterValues("id");
            String[] nombres=request.getParameterValues("nombre");
            String[] apellidos=request.getParameterValues("apellidos");
            String[] dnis=request.getParameterValues("dni");
            String[] telefonos=request.getParameterValues("telefono");
            String[] emails=request.getParameterValues("email");
            /*response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+nombres[0]+"<h1>");
            out.println("<h1>"+nombres[1]+"<h1>");
            out.println("</body>");
            out.println("</html>");
        }
        */
            for(int i=0;i<idModificar.length;i++){
                int idCliente=Integer.parseInt(idModificar[i]);
                Cliente cliente = new Cliente(idCliente,nombres[i],apellidos[i],dnis[i],telefonos[i],emails[i]);
                clienteService.modificar(cliente);
                
            }
            
            
            ArrayList<Cliente> clientes = clienteService.listar();
            request.getSession().setAttribute("listaClientes", clientes);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/listarCliente.jsp");
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
