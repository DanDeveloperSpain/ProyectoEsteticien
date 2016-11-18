<%-- 
    Document   : finalizarCompra
    Created on : 17-nov-2016, 19:37:43
    Author     : Vicente
--%>

<%@page import="com.fpmislata.domain.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fpmislata.domain.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Cliente cliente = (Cliente) request.getAttribute("cliente");
           ArrayList<Producto> productosVendidos = (ArrayList<Producto>) request.getAttribute("prodsVendidos");        
        %>
        <h1>Datos Cliente</h1>
        <table>
            <tr>
                <td><%=cliente.getNombre()%> <%=cliente.getApellidos()%></td>
                <td><%=cliente.getTelefono()%></td>
            </tr>
        </table>
        <h1>Datos Productos</h1>
        <table>
            <% for(Producto prod : productosVendidos){ %>
                    <tr>
                        <td><%=prod.getNombreProducto()%></td>
                        <td><%=prod.getPrecioProducto()%></td>
                    </tr>
            <% } %>
        </table>
        <br>
        <form action="VentaProductos?accion=confirmarVenta" method="POST" >
            Establecer Fecha: <input type="date" name="fechaVenta" value="" required /><br>
            <input type="submit" value="Confirmar Venta" />
        </form>
        <a href="index.jsp">Cancelar Venta, y Volver al Inicio</a>
                
    </body>
</html>
