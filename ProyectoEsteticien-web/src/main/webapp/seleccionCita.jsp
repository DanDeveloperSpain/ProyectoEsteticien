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
        <title>JSP Page</title>
    </head>

    <%  ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) session.getAttribute("listaCli"); %>
    <%  ArrayList<Tratamiento> listaTratamientos = (ArrayList<Tratamiento>) session.getAttribute("listaTrat"); %>
    <form action="ConcertarCita?accion=segundo" method="POST" name="listado">

        <fieldset class="contenido" id="cleintes">
            <legend>Clientes</legend>
            <table border="0" cellspacing="0" cellspadding="10">
                <tr>
                    <td>Nombre</td>
                    <td>Apellidos</td>
                    <td>Dni</td>
                    <td>Telefono</td>
                    <td>Email</td>
                    <td></td>
                </tr>
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
        </fieldset>


        <fieldset class="contenido" id="tratamientos">
            <legend>Tratamientos</legend>
            <table border="0" cellspacing="0" cellspadding="10">
                <tr>
                    <td>Nombre Tratamiento</td>
                    <td>Precio</td>
                    <td>Duracion</td>
                    <td>Sala</td>
                    <td>Selecionar</td>
                </tr>
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
        </fieldset>

        <fieldset class="contenido" id="tratamientos">
            <legend>Fecha</legend>
            <table border="0" cellspacing="0" cellspadding="10">
                <tr>
                    <td>Dia Cita</td>
                    <td>Hora Cita</td>
                </tr>
                <tr>
                    <td><input type="date" name="dia" value=""/></td>
                    <td><input type="time" name="hora" value=""/></td>
            </table>
        </fieldset>


        <input type = "submit" value="Confirmar Cita"/>
    </form>
    <a href="index.jsp">Regresar al Inicio</a>

</html>