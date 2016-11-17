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
        <title>JSP Page</title>
   </head>
    
        <%  ArrayList<Producto> listaProductos = (ArrayList<Producto>) request.getAttribute("listaProductos"); %>
        <form action="VentaProductos?accion=selectProducto" method="POST" name="listado">
            <table border="0" cellspacing="0" cellspadding="10">
                <tr>
                    <td>Producto</td>
                    <td>Categoría</td>
                    <td>Precio</td>
                    <td></td>
                </tr>
                <% for(Producto prod : listaProductos){ %>
                    <tr>
                        <td><%=prod.getNombreProducto()%></td>
                        <td><%=prod.getCategoriaProducto()%></td>
                        <td><%=prod.getPrecioProducto()%></td>
                        <td><input type="checkbox" name="productoChecked" value="<%=prod.getId()%>"</td>
                    </tr>
                <% } %>    
            </table>
            <input type = "submit" value="Seleccionar"/>
        </form>
        <a href="index.jsp">Regresar al Inicio</a>
    
</html>
