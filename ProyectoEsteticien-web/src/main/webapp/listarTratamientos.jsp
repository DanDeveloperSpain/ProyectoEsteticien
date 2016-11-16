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
        <title>JSP Page</title>
    </head>
    <body>

	<h1>Listado Tratamientos</h1>
        
	<a href="agregarTratamiento.jsp">Agregar Tratamiento</a>
	<br/>
	<br/>

	<table border="1">
		<tr>
                    <th>Nombre Tratamiento</th>
                    <th>Precio Tratamiento</th>
                    <th>Duracion Tratamiento</th>
                    <th>Sala Tratamiento</th>
                    <th></th>
                    <th></th>
 
		</tr>

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
                    <td><a href="ModificarTratamiento?accion=editar&id=<%=id%>">Modificar</td>
                    <td><a href="EliminarTratamiento?id=<%=id%>">Eliminar</a></td>
                </tr>
                <% } %>
	</table>
	<br>
	<a href="index.jsp">Regresar al Inicio</a>
</body>
</html>
