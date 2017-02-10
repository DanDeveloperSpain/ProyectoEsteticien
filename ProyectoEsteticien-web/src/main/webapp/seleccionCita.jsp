<%-- 
    Document   : seleccionCita
    Created on : 18-nov-2016, 9:53:35
    Author     : DanielPerez
--%>

<%@page import="com.fpmislata.domain.Tratamiento"%>
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

    <%  ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) session.getAttribute("clientes"); %>
    <%  ArrayList<Tratamiento> listaTratamientos = (ArrayList<Tratamiento>) session.getAttribute("tratamientos"); %>
    <form action="ConcertarCita" method="POST" name="listado">

        <h2>Clientes</h2>
        <table class="table table-condensed table-responsive" border="0" cellspacing="0" cellspadding="10">
            <thead>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Dni</th>
            <th>Telefono</th>
            <th>Email</th>
            <th>Seleccionar</th>
            </thead>
            <% for (Cliente cliente : listaClientes) {%>
            <tr>
                <td><%=cliente.getNombre()%></td>
                <td><%=cliente.getApellidos()%></td>
                <td><%=cliente.getDni()%></td>
                <td><%=cliente.getTelefono()%></td>
                <td><%=cliente.getEmail()%></td>
                <td><input type="radio" name="clienteChecked" value="<%=cliente.getId()%>"</td>
            </tr>
            <% }%>    
        </table>

        <br>
        <h2>Tratamientos</h2>
        <table class="table table-condensed table-responsive" border="0" cellspacing="0" cellspadding="10">
            <thead>
                <tr>
                    <th>Nombre Tratamiento</th>
                    <th>Precio</th>
                    <th>Duracion</th>
                    <th>Sala</th>
                    <th>Selecionar</th>
                </tr>
            </thead>
            <% for (Tratamiento tratamiento : listaTratamientos) {%>
            <tr>
                <td><%=tratamiento.getNombreTrat()%></td>
                <td><%=tratamiento.getPrecioTrat()%>€</td>
                <td><%=tratamiento.getDuracionTrat()%></td>
                <td><%=tratamiento.getSala()%></td>
                <td><input type="radio" name="tratamientoChecked" value="<%=tratamiento.getId()%>"</td>
            </tr>
            <% }%>    
        </table>

        <br>
        <h2>Fecha</h2>
        <table class="table table-condensed table-responsive" border="0" cellspacing="0" cellspadding="10">
            <tr>
                <th>Dia Cita <input type="date" name="dia" value=""/></th>
                <th>Hora Cita <input type="time" name="hora" value=""/></th>
            </tr>
        </table>



        <input class="btn btn-success" type = "submit" value="Confirmar Cita"/>
    </form>
    <br>
    <a href="index.jsp" class="btn btn-primary">Regresar al Inicio</a>
    <br><br>

</html>