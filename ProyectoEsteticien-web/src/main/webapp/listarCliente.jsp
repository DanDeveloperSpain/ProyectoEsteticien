<%-- 
    Document   : listarCliente
    Created on : 16-nov-2016, 10:12:09
    Author     : alumno
--%>

<%@page import="com.fpmislata.domain.Cita"%>
<%@page import="com.fpmislata.domain.Venta"%>
<%@page import="com.fpmislata.domain.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" media="screen" />
        <title>Listado de Clientes</title>
        <script >
            function calA() {
                document.listado.action = "EliminarCliente";
            }
            function calB() {
                document.listado.action = "ModificarCliente?accion=cambiarDatos";
            }
        </script>
    </head>

    <%  ArrayList<Cliente> listaClientes = (ArrayList) session.getAttribute("listaClientes"); %>
    <a href="agregarCliente.jsp" class="btn btn-success">Nuevo Cliente</a>
    <br>
    <br>
    <form action="ListarClientesPorSexo" method="post" class="form-horizontal">
        <select name="sexo">
            <option value="todos">Todos</option>
            <option value="femenino">Femenino</option>
            <option value="masculino">Masculino</option>
        </select>
        <input type="submit" name="Buscar" class="btn btn-info">
    </form>
    <br>
    <br>
    <form action="" method="POST" name="listado">
        <table border="0" cellspacing="0" cellspadding="10" class="table table-condensed table-responsive">
            <thead>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Sexo</th>
            <th>Dni</th>
            <th>Telefono</th>
            <th>Email</th>
            <th>Eliminar/Modificar</th>
            <th></th>
            </thead>
            <tbody>
                <% for (Cliente cliente : listaClientes) {%>

                <tr>
                    <td><%=cliente.getNombre()%></td>
                    <td><%=cliente.getApellidos()%></td>
                    <td><%=cliente.getSexo()%></td>
                    <td><%=cliente.getDni()%></td>
                    <td><%=cliente.getTelefono()%></td>
                    <td><%=cliente.getEmail()%></td>
                    <td><input type="checkbox" name="clienteChecked" value="<%=cliente.getId()%>"</td>
                    <td class="text-center"><a href="ListarVentasCliente?accion=comienzo&id=<%=cliente.getId()%>" class="btn btn-info">Ver ventas</a></td>
                    <td class="text-center"><a href="ListarVentasCliente?accion=listarCitas&id=<%=cliente.getId()%>" class="btn btn-success">Ver citas</a></td>
                </tr>
                <% }%>  
            </tbody>
        </table>
        <input type = "submit" onclick=calA() value="Eliminar" class="btn btn-danger"/>
        <input type = "submit" onclick=calB() value="Modificar" class="btn btn-warning"/>
    </form>
    <br><br>
    <%ArrayList<Venta> listaVenta = (ArrayList) request.getAttribute("ventasCli");
        if (listaVenta != null) {%>
    <h2>Ventas del cliente selecionado</h2>

    <table class="table table-condensed table-responsive">
        <thead>
            <tr>
                <th>Nombre Producto</th>
                <th>Categoria</th>
                <th>Precio</th>               
            </tr>
        </thead>

        <%for (Venta venta : listaVenta) {

            int id = venta.getId();
            String dia = venta.getFecha();
            double precio = venta.getPrecioTotal();
            String nombreCli = venta.getCliente().getNombre();

        %>                
        <tr>
            <td><%=nombreCli%></td>
            <td><%=dia%></td>
            <td><%=precio%></td>
        </tr>
        <% }%>
    </table>
    <%}%>
    <br><br>

    <%ArrayList<Cita> listaCitas = (ArrayList) request.getAttribute("citasCli");
                if (listaCitas != null) {%>
    <h2>Citas del cliente selecionado</h2>

    <table class="table table-condensed table-responsive">
        <thead>
            <tr>
                <th>Cliente</th>
                <th>Fecha</th>
                <th>Tratamiento</th>
                <th>Precio</th>               
            </tr>
        </thead>
        <%
            for (Cita cita : listaCitas) {

                String nombreCli = cita.getCliente().getNombre();
                String dia = cita.getFecha();
                String nombreTrat = cita.getTratamiento().getNombreTrat();
                double precioTrat = cita.getTratamiento().getPrecioTrat();
        %>                
        <tr>
            <td><%=nombreCli%></td>
            <td><%=dia%></td>
            <td><%=nombreTrat%></td>
            <td><%=precioTrat%></td>
        </tr>
        <% }%>
    </table>
    <%}%>
    <a href="index.jsp" class="btn btn-primary" >Regresar al Inicio</a>

</html>
