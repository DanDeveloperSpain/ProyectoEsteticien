<%-- 
    Document   : finalizarCompra
    Created on : 17-nov-2016, 19:37:43
    Author     : Vicente
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="com.fpmislata.domain.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fpmislata.domain.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" media="screen" />
        <title>JSP Page</title>
    </head>
    <body>
        <% Cliente cliente = (Cliente) request.getAttribute("cliente");
           ArrayList<Producto> productosVendidos = (ArrayList<Producto>) request.getAttribute("prodsVendidos");
           Double precioTotalVenta = (Double) request.getAttribute("precioTotal");
           DecimalFormat df = new DecimalFormat("#.##");

         %>
        <div class="container">
            <div class="row">
                <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <address>
                                <strong><%=cliente.getNombre()%> <%=cliente.getApellidos()%></strong>
                                <br>
                                <%=cliente.getDni()%>
                                <br>
                                <%=cliente.getTelefono()%>
                                <br>
                                <%=cliente.getEmail()%>
                            </address>
                        </div>
                    </div>
                    <div class="row">
                        <div class="text-center">
                            <h1>Datos Compra</h1>
                        </div>
                        </span>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Producto</th>
                                    <th class="text-center">Precio</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for(Producto prod : productosVendidos){ %>
                                    <tr>
                                        <td><%=prod.getNombreProducto()%></td>
                                        <td class="text-center"><%=prod.getPrecioProducto()%> €</td>
                                    </tr>
                                <% } %>
                                <tr>
                                    <td class="text-right"><h4><strong>Total: </strong></h4></td>
                                    <td class="text-center text-danger"><h4><strong><%=df.format(precioTotalVenta)%>€</strong></h4></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <form action="VentaProductos?accion=confirmarVenta" method="POST" >
                        Establecer Fecha: <input type="date" name="fechaVenta" value="" required />
                        <input type="submit" value="Confirmar Venta" class="btn btn-success"/>
                    </form>                    
                </div>
                <div class="col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
                    <a href="index.jsp" class="btn btn-danger">Cancelar Venta y Volver al Inicio</a>
                </div>
            </div>
        </div>
                        
    </body>
</html>
