<%-- 
    Document   : modificarCliente
    Created on : 16-nov-2016, 10:12:47
    Author     : alumno
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
    <body>
        <% ArrayList<Cliente> clientesAModificar = (ArrayList<Cliente>) request.getAttribute("clientesModificar");%>
        <% 
            String textoAction="ModificarCliente?accion=confirmarModif";
            for(int i=0;i<clientesAModificar.size();i++){
                textoAction+="&id="+clientesAModificar.get(i).getId();
            }
        %>
                
        <form action=<%=textoAction%> method="POST" name="listado">
        <table border="0" cellspacing="0" cellspadding="10">
            <tr>
                    <td>Nombre</td>
                    <td>Apellidos</td>
                    <td>Dni</td>
                    <td>Telefono</td>
                    <td>Email</td>
            </tr>
            <% for(int i=0;i<clientesAModificar.size();i++){%>
                <tr>
                    <td><input type="text" name="nombre" value=<%=clientesAModificar.get(i).getNombre()%> required /></td>
                    <td><input type="text" name="apellidos" value=<%=clientesAModificar.get(i).getApellidos()%> required /></td>
                    <td><input type="text" name="dni" value=<%=clientesAModificar.get(i).getDni()%> required /></td>
                    <td><input type="text" name="telefono" value=<%=clientesAModificar.get(i).getTelefono()%> required /></td>
                    <td><input type="text" name="email" value=<%=clientesAModificar.get(i).getEmail()%> required /></td>
                </tr>
            <% } %>    
        </table>
        <input type = "submit" value="Confirmar Cambios"/>
        <input type = "reset" value="Restaurar Datos"/>
        </form>
    </body>
</html>
