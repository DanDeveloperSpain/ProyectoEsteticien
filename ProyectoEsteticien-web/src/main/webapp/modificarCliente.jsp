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
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" media="screen" />
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
        <table border="0" cellspacing="0" cellspadding="10" class="table table-condensed table-responsive">
            <thead>
                <tr>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Dni</th>
                        <th>Telefono</th>
                        <th>Email</th>
                </tr>
            </thead>
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
        <input type = "submit" value="Confirmar Cambios" class="btn btn-success"/>
        <input type = "reset" value="Restaurar Datos" class="btn btn-danger"/>
        </form>
    </body>
</html>
