<%-- 
    Document   : listarCliente
    Created on : 16-nov-2016, 10:12:09
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
        <script >
            function calA(){
                document.listado.action ="EliminarCliente";
            }
            function calB(){
                document.listado.action ="ModificarCliente?accion=cambiarDatos";
            }
        </script>
    </head>
    
        <%  ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) session.getAttribute("listaClientes"); %>
        <a href="agregarCliente.jsp" class="btn btn-success">Nuevo Cliente</a>
        <form action="" method="POST" name="listado">
        <table border="0" cellspacing="0" cellspadding="10" class="table table-condensed table-responsive">
            <thead>
                    <th>Nombre</th>
                    <th>Apellidos</th>
                    <th>Dni</th>
                    <th>Telefono</th>
                    <th>Email</th>
                    <th></th>
            </thead>
            <tbody>
            <% for(Cliente cliente : listaClientes){ %>
                <tr>
                    <td><%=cliente.getNombre()%></td>
                    <td><%=cliente.getApellidos()%></td>
                    <td><%=cliente.getDni()%></td>
                    <td><%=cliente.getTelefono()%></td>
                    <td><%=cliente.getEmail()%></td>
                    <td><input type="checkbox" name="clienteChecked" value="<%=cliente.getId()%>"</td>
                </tr>
            <% } %>  
            </tbody>
        </table>
        <input type = "submit" onclick=calA() value="Eliminar" class="btn btn-danger"/>
        <input type = "submit" onclick=calB() value="Modificar" class="btn btn-warning"/>
        </form>
        <a href="index.jsp" class="btn btn-primary" >Regresar al Inicio</a>
    
</html>
