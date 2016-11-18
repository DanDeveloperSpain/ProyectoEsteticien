<%-- 
    Document   : agregarCliente
    Created on : 16-nov-2016, 10:10:11
    Author     : alumno
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
    <body>
        <h2>Nuevo Cliente</h2>
        <form action="AltaCliente">
            <table class="table table-condensed table-responsive">
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="" required /></td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td><input type="text" name="apellidos" value="" required /></td>
                </tr>
                <tr>
                    <td>Dni</td>
                    <td><input type="text" name="dni" value="" required /></td>
                </tr>
                <tr>
                    <td>Telefono</td>
                    <td><input type="text" name="telefono" value="" required /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" value="" required  /></td>
                </tr>
            </table>
            <input type="submit" value="Nuevo Cliente" class="btn btn-success"/>
        </form>
    </body>
</html>
