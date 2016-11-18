<%-- 
    Document   : listarTratamientos
    Created on : 14-nov-2016, 9:56:38
    Author     : DanielPerez
--%>

<%@page import="java.util.ArrayList"%>
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

	<h1>Listado Tratamientos</h1>
        
	<a href="agregarTratamiento.jsp" class="btn btn-success">Agregar Tratamiento</a>
	<br/>
	<br/>

	<table class="table table-condensed table-responsive">
            <thead>
                <tr>
                    <th>Nombre Tratamiento</th>
                    <th>Precio Tratamiento</th>
                    <th>Duracion Tratamiento</th>
                    <th>Sala Tratamiento</th>
                    <th colspan="2" class="text-center">Accion</th>                    
		</tr>
            </thead>
            <%
            ArrayList<Tratamiento> lista = (ArrayList) session.getAttribute("tratamientos");
            for(Tratamiento tratamiento : lista){

                int id = tratamiento.getId();
                String nombreTrat = tratamiento.getNombreTrat();
                double precioTrat = tratamiento.getPrecioTrat();
                double duracionTrat = tratamiento.getDuracionTrat();
                int sala = tratamiento.getSala();
            %>                
            <tr>
                <td><%=nombreTrat%></td>
                <td><%=precioTrat%></td>
                <td><%=duracionTrat%></td>
                <td><%=sala%></td>
                <td class="text-center"><a href="ModificarTratamiento?accion=editar&id=<%=id%>" class="btn btn-warning">Modificar</td>
                <td class="text-center"><a href="EliminarTratamiento?id=<%=id%>" class="btn btn-danger">Eliminar</a></td>
            </tr>
            <% } %>
	</table>
	<br>
	<a href="index.jsp" class="btn btn-primary">Regresar al Inicio</a>
</body>
</html>
