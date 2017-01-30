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
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" media="screen" />
        <title>Modificar Tratamiento</title>
    </head>
    <body>

    <h1>Modificar Tratamiento</h1>

    <form action="ModificarTratamiento?opcion=modificar&id=${tratamiento.id}" method="post" class="form-horizontal">
        <div class="form-group">   
            <label for="nombre" class="control-label col-sm-1">Nombre:</label>
            <div class="col-sm-11">
                <input type="text" name="nombre" value="${tratamiento.nombreTrat}" style="display: block;" />
            </div>
        </div>
        <div class="form-group"> 
            <label for="email" class="control-label col-sm-1">Precio:</label>
            <div class="col-sm-11">
                <input type="text" name="precio" value="${tratamiento.precioTrat}" style="display: block;"/>
            </div>
        </div>
        <div class="form-group">
            <label for="telefono" class="control-label col-sm-1">Duración:</label>
            <div class="col-sm-11">
                <input type="text" name="duracion" value="${tratamiento.duracionTrat}" style="display: block;"/>
            </div>
        </div>
        <div class="form-group">
            <label for="telefono" class="control-label col-sm-1">Sala:</label>
            <div class="col-sm-11">
                <input type="text" name="sala" value="${tratamiento.sala}" style="display: block;"/>
            </div>
        </div>
        <div class="col-sm-10">
            <input type="submit" name="guardar" value="guardar" class="btn btn-success">
        </div>
    </form>
</body>
</html>
