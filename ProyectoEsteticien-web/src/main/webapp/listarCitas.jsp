<%-- 
    Document   : listarCitas
    Created on : 20-nov-2016, 13:49:35
    Author     : DanielPerez
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.fpmislata.domain.Cita"%>
<%@page import="com.fpmislata.domain.Cliente"%>
<%@page import="com.fpmislata.domain.Tratamiento"%>
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

	<h1>Listado de Citas</h1>
        
        <a href="seleccionCita.jsp" class="btn btn-success">Asignar Citas</a>

	<table class="table table-condensed table-responsive">
            <thead>
                <tr>
                    <th>Dia</th>
                    <th>Hora</th>
                    <th>Nombre Cliente</th>
                    <th>Nombre Trat</th>                   
		</tr>
            </thead>
            <%
            ArrayList<Cita> listaCita = (ArrayList) session.getAttribute("citas");
            //ArrayList<Cliente> listaCli = (ArrayList) session.getAttribute("clientes");
            //ArrayList<Tratamiento> listaTrat = (ArrayList) session.getAttribute("tratamientos");
            int i=0;
            for(Cita cita : listaCita){

                int id = cita.getId();
                String dia = cita.getFecha();
                String hora = cita.getHora();
                String nombreCli = cita.getCliente().getNombre();
                String nombreTrat = cita.getTratamiento().getNombreTrat();
                //String nombreCli = listaCli.get(i).getNombre();
                //String nombreTrat = listaTrat.get(i).getNombreTrat();
                
                i++;
            %>                
            <tr>
                <td><%=dia%></td>
                <td><%=hora%></td>
                <td><%=nombreCli%></td>
                <td><%=nombreTrat%></td>
            </tr>
            <% } %>
	</table>
	<br>
	<a href="index.jsp" class="btn btn-primary">Regresar al Inicio</a>
</body>
</html>
