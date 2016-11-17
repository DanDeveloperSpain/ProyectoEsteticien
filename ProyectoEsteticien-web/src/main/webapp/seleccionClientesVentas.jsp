<%-- 
    Document   : seleccionClientesVentas
    Created on : 17-nov-2016, 17:24:20
    Author     : Vicente
--%>

<%@page import="com.fpmislata.domain.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
   </head>
    
        <%  ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) session.getAttribute("listaClientes"); %>
        <form action="VentaProductos?accion=selectCliente" method="POST" name="listado">
            <table border="0" cellspacing="0" cellspadding="10">
                <tr>
                        <td>Nombre</td>
                        <td>Apellidos</td>
                        <td>Dni</td>
                        <td>Telefono</td>
                        <td>Email</td>
                        <td></td>
                    </tr>
                <% for(Cliente cliente : listaClientes){ %>
                    <tr>
                        <td><%=cliente.getNombre()%></td>
                        <td><%=cliente.getApellidos()%></td>
                        <td><%=cliente.getDni()%></td>
                        <td><%=cliente.getTelefono()%></td>
                        <td><%=cliente.getEmail()%></td>
                        <td><input type="radio" name="clienteChecked" value="<%=cliente.getId()%>"</td>
                    </tr>
                <% } %>    
            </table>
            <input type = "submit" value="Seleccionar"/>
        </form>
        <a href="index.jsp">Regresar al Inicio</a>
    
</html>
