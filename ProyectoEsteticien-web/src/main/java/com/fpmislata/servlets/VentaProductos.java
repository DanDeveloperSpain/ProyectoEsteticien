/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.Cliente;
import com.fpmislata.domain.Producto;
import com.fpmislata.domain.Venta;
import com.fpmislata.service.ClienteServiceLocal;
import com.fpmislata.service.ProductoServiceLocal;
import com.fpmislata.service.VentaServiceLocal;
import java.io.IOException;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vicente
 */
public class VentaProductos extends HttpServlet {

    @EJB
    private VentaServiceLocal ventaService;
    @EJB
    private ClienteServiceLocal clienteService;
    @EJB
    private ProductoServiceLocal productoService;
    

    
    
    
    

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
        
        int idCliente;
        String accion = request.getParameter("accion");//debe venir del envio desde el index.jsp
        String[] idProductos;
        ArrayList<Producto> productosVendidos = new ArrayList<>();
        
        switch(accion){
            case "comienzo":
                ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) request.getSession().getAttribute("listaClientes");
                if(listaClientes==null){
                    listaClientes=clienteService.listar();
                }
                request.getSession().setAttribute("listaClientes", listaClientes);
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/seleccionClientesVentas.jsp");
                rd.forward(request, response);
            ;break;
            case "selectCliente":
                idCliente = Integer.parseInt(request.getParameter("clienteChecked"));
                request.getSession().setAttribute("idCliente", idCliente);
                                
                ArrayList<Producto> listaProductos = productoService.listarProductos();
                
                request.setAttribute("listaProductos",listaProductos);
                rd = this.getServletContext().getRequestDispatcher("/seleccionProductosVentas.jsp");
                rd.forward(request, response);
            ;break;
            case "selectProducto":
                idCliente= (int) request.getSession().getAttribute("idCliente");
                Cliente cl = new Cliente(idCliente,"","","","","");
                Cliente cliente = clienteService.mostrarUno(cl);
                
                idProductos = (request.getParameterValues("productoChecked"));//este array es de Strings
                request.getSession().setAttribute("idProductos", idProductos);
                if(idProductos!=null){
                    for(int i=0;i<idProductos.length;i++){
                        int idProd = Integer.parseInt(idProductos[i]);
                        Producto prod=new Producto(idProd,"","",0);
                        Producto producto = productoService.mostrarUno(prod);
                        productosVendidos.add(producto);
                    }
                }
                
                request.setAttribute("cliente", cliente);
                request.setAttribute("productoVendidos", productosVendidos);
                rd = this.getServletContext().getRequestDispatcher("/finalizarVentaProductos.jsp");
                rd.forward(request, response);
                
            ;break;
            case "confirmarVenta":
                idCliente= (int) request.getSession().getAttribute("idCliente");
                idProductos= (String[]) request.getSession().getAttribute("idProductos");
                String fechaVenta = request.getParameter("fechaVenta");
                for(int i=0;i<idProductos.length;i++){
                        int idProd = Integer.parseInt(idProductos[i]);
                        Venta venta = new Venta(0,idCliente,idProd,fechaVenta);
                        ventaService.agregarVenta(venta);
                }
            rd = this.getServletContext().getRequestDispatcher("/index.jsp");
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
