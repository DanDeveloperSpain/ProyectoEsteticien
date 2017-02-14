<%-- 
    Document   : listarVentaCompleta
    Created on : 13-feb-2017, 19:59:56
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
        <title>Listar Ventas</title>
    </head>
    <body>
        <h1>Listado Completo de Ventas</h1>
        <br>
        <table class="table table-condensed table-responsive">
            <thead>
                <tr>
                    <th>Nombre Producto</th>
                    <th>Categoria</th>
                    <th>Precio</th>               
		</tr>
            </thead>
            <%
            ArrayList<Producto> lista = (ArrayList) session.getAttribute("productos");
            int i=0;
            for(Producto producto : lista){

                int id = producto.getId();
                String nombre = producto.getNombreProducto();
                String categoria = producto.getCategoriaProducto();
                double precio= producto.getPrecioProducto();
                
                i++;
            %>                
            <tr>
                <td><%=nombre%></td>
                <td><%=categoria%></td>
                <td><%=precio%></td>
            </tr>
            <% } %>
	</table>
	<br>
        <a href="ListarVentas?accion=comienzo" class="btn btn-success">Regresar a ventas</a>
        <br>
        <br>
	<a href="index.jsp" class="btn btn-primary">Regresar al Inicio</a>
</body>
</html>
