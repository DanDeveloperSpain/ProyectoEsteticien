<%-- 
    Document   : listarVentas
    Created on : 13-feb-2017, 19:33:54
    Author     : DanielPerez
--%>

<%@page import="java.util.Set"%>
<%@page import="com.fpmislata.domain.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fpmislata.domain.Venta"%>
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
        <h1>Listado de Ventas</h1>
        <br>
        <table class="table table-condensed table-responsive">
            <thead>
                <tr>
                    <th>Cliente</th>
                    <th>Dia</th>
                    <th>Precio</th>               
                </tr>
            </thead>
            <%
                ArrayList<Venta> listaVenta = (ArrayList) session.getAttribute("ventas");
                int i = 0;
                for (Venta venta : listaVenta) {

                    int id = venta.getId();
                    String dia = venta.getFecha();
                    double precio = venta.getPrecioTotal();
                    String nombreCli = venta.getCliente().getNombre();
                    //ArrayList<Producto> listaArrayProductos = new ArrayList<>(venta.getProductos());

                    i++;
            %>                
            <tr>
                <td><%=nombreCli%></td>
                <td><%=dia%></td>
                <td><%=precio%></td>
                <td class="text-center"><a href="ListarVentas?accion=listarProd&id=<%=id%>" class="btn btn-warning">Ver Venta</td>
            </tr>
            <% } %>
        </table>
        <br><br>
        <h2>Detalle de venta selecionada</h2>
        <table class="table table-condensed table-responsive">
            <thead>
                <tr>
                    <th>Nombre Producto</th>
                    <th>Categoria</th>
                    <th>Precio</th>               
                </tr>
            </thead>
            <%

                ArrayList<Producto> lista = (ArrayList) request.getAttribute("productosVenta");
                if (lista != null) {
                    for (Producto producto : lista) {

                        int id = producto.getId();
                        String nombre = producto.getNombreProducto();
                        String categoria = producto.getCategoriaProducto();
                        double precio = producto.getPrecioProducto();

            %>                
            <tr>
                <td><%=nombre%></td>
                <td><%=categoria%></td>
                <td><%=precio%></td>
            </tr>
                <% }%>
                
               <%}%>
        </table>
        <a href="index.jsp" class="btn btn-primary">Regresar al Inicio</a>
    </body>
</html>
