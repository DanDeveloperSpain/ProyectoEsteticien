<%-- 
    Document   : listarProductos
    Created on : 10-feb-2017, 18:11:24
    Author     : DanielPerez
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.fpmislata.domain.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" media="screen" />
        <title>Listado de Productos</title>
    </head>
    <body>

	<h1>Listado Productos</h1>
        
	<a href="agregarProducto.jsp" class="btn btn-success">Nueva venta Producto</a>
	<br/>
	<br/>

	<table class="table table-condensed table-responsive">
            <thead>
                <tr>
                    <th>Nombre Producto</th>
                    <th>Categoria Producto</th>
                    <th>Precio Producto</th>                 
		</tr>
            </thead>
            <%
            ArrayList<Producto> lista = (ArrayList) session.getAttribute("productos");
            for(Producto producto : lista){

                int id = producto.getId();
                String nombreTrat = producto.getNombreProducto();
                String precioTrat = producto.getCategoriaProducto();
                double duracionTrat = producto.getPrecioProducto();
            %>                
            <tr>
                <td><%=nombreTrat%></td>
                <td><%=precioTrat%></td>
                <td><%=duracionTrat%></td>
            </tr>
            <% } %>
	</table>
	<br>
	<a href="index.jsp" class="btn btn-primary">Regresar al Inicio</a>
</body>
</html>
