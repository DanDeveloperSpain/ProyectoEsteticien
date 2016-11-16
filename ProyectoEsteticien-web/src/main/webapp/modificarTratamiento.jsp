<%-- 
    Document   : modificarTratamiento
    Created on : 16-nov-2016, 9:12:37
    Author     : DanielPerez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Tratamiento</title>
    </head>
    <body>

    <h1>Modificar Tratamiento</h1>

    <form action="ModificarTratamiento?accion=modificar&id=${tratamiento.id}" method="post">

        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" value="${tratamiento.nombreTrat}" style="display: block;" />

        <label for="email">Precio:</label>
        <input type="text" name="precio" value="${tratamiento.precioTrat}" style="display: block;"/>

        <label for="telefono">Duración:</label>
        <input type="text" name="duracion" value="${tratamiento.duracionTrat}" style="display: block;"/>
        
        <label for="telefono">Sala:</label>
        <input type="text" name="sala" value="${tratamiento.sala}" style="display: block;"/>

        <input type="submit" name="guardar" value="guardar">
    </form>
</body>
</html>
