<%-- 
    Document   : index
    Created on : 14-nov-2016, 9:40:10
    Author     : DanielPerez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" media="screen" />
        <title>JSP Page</title>
    </head>
    <script>
        <% String ventaRealizada = (String) request.getAttribute("ventaRealizada"); %>
        <% String citaAsignada = (String) request.getAttribute("citaAsignada"); %>
            
        <% if(ventaRealizada!=null){
            int ventaProducida = Integer.parseInt(ventaRealizada);
            if(ventaProducida==1){
        }%>
            window.onload=function(){
                alert("La venta se ha producido sin problemas");
            }
        <% } %>
        
        <% if(citaAsignada!=null){
            int citaAsignadaOk = Integer.parseInt(citaAsignada);
            if(citaAsignadaOk==1){
        }%>
            window.onload=function(){
                alert("La Cita se ha asignado correctamente");
            }
        <% } %>
        
        
            
            
    </script>
    <body>
       
        <h2>Sistema de Gestión Esteticien (SGE)</h2>
        <a href="ListarClientes" class="btn btn-primary">Listado de Clientes</a>
        <a href="ListarTratamientos" class="btn btn-primary">Listado de Tratamientos</a>
        <a href="ListarCitas" class="btn btn-primary">Citas</a>
        <a href="ListarProductos" class="btn btn-primary">Ver Productos</a>
        <a href="VentaProductos?accion=comienzo" class="btn btn-primary">Venta de Productos</a>
        <a href="ListarVentas?accion=comienzo" class="btn btn-primary">Ver Ventas</a>
        <!--<a href="VentaProductos?accion=comienzo" class="btn btn-primary">Venta de Productos</a>-->
    </body>
</html>
