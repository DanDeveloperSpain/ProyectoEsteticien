<%-- 
    Document   : ventaProductos
    Created on : 12-feb-2017, 14:20:11
    Author     : DanielPerez
--%>

<%@page import="com.fpmislata.domain.Cliente"%>
<%@page import="com.fpmislata.domain.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" media="screen" />
        <title>Venta Productos</title>
    </head>
    <body>
        
        <h1>Realizar Venta</h1>
        <br>
        
        <%  ArrayList<Producto> listaProductos = (ArrayList<Producto>) session.getAttribute("listaProductos"); %>
        <%  ArrayList<Cliente> listaClientes = (ArrayList) session.getAttribute("listaClientes"); %>
        
        <form action="VentaProductos?accion=confirmarVenta" method="POST" name="listado">
            <h4>Fecha Venta <input type="date" name="dia" value=""/></h4>
            <h2>Seleccionar Productos</h2>
            <table border="0" cellspacing="0" cellspadding="10" class="table table-condensed table-responsive">
                <thead>
                    <tr>
                        <th>Producto</th>
                        <th>Categoría</th>
                        <th>Precio</th>
                        <th></th>
                    </tr>
                </thead>
                <% for(Producto prod : listaProductos){ %>
                    <tr>
                        <td><%=prod.getNombreProducto()%></td>
                        <td><%=prod.getCategoriaProducto()%></td>
                        <td><%=prod.getPrecioProducto()%> €</td>
                        <td><input type="checkbox" name="productoChecked" value="<%=prod.getId()%>"</td>
                    </tr>
                <% } %>    
            </table>
            <h2>Seleccionar Clientes</h2>
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
                    <td><input type="radio" name="clienteChecked" value="<%=cliente.getId()%>"</td>
                </tr>
            <% } %>  
            </tbody>
        </table>
            <input type = "submit" value="Seleccionar" class="btn btn-success"/>
        </form>
        <a href="index.jsp" class="btn btn-primary">Regresar al Inicio</a>
    </body>
</html>
