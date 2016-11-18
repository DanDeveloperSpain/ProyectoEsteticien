<%-- 
    Document   : seleccionProductosVentas
    Created on : 17-nov-2016, 17:25:17
    Author     : Vicente
--%>

<%@page import="com.fpmislata.domain.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" media="screen" />
        <title>JSP Page</title>
   </head>
    
        <%  ArrayList<Producto> listaProductos = (ArrayList<Producto>) request.getAttribute("listaProductos"); %>
        <form action="VentaProductos?accion=selectProducto" method="POST" name="listado">
            <table border="0" cellspacing="0" cellspadding="10" class="table table-condensed table-responsive">
                <thead>
                    <tr>
                        <th>Producto</th>
                        <th>Categoría</th>
                        <th>Precio</th>
                        <th></th>
                    </tr>
                </thead>
                <% for(Producto prod : listaProductos){ %>
                    <tr>
                        <td><%=prod.getNombreProducto()%></td>
                        <td><%=prod.getCategoriaProducto()%></td>
                        <td><%=prod.getPrecioProducto()%></td>
                        <td><input type="checkbox" name="productoChecked" value="<%=prod.getId()%>"</td>
                    </tr>
                <% } %>    
            </table>
            <input type = "submit" value="Seleccionar" class="btn btn-success"/>
        </form>
        <a href="index.jsp" class="btn btn-primary">Regresar al Inicio</a>
    
</html>
