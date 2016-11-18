<%-- 
    Document   : agregarTratamiento
    Created on : 14-nov-2016, 18:51:13
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
<body>

	<h1>Agregar Tratamiento</h1>
	
	<form action="AltaTratamiento" method="post" class="form-horizontal">
		<input type="hidden" name="accion" value="agregar"/>
            <div class="form-group">    
		<label for="nombre" class="control-label col-sm-2">Nombre Tratamiento:</label>
                <div class="col-sm-10">
                    <input type="text" name="nombre" style="display: block;" />
                </div>
            </div>
            <div class="form-group">   
		<label for="precio" class="control-label col-sm-2">Precio Tratamiento:</label>
                <div class="col-sm-10">
                    <input type="text" name="precio" style="display: block;"/>
                </div>
            </div>
            <div class="form-group">
		<label for="duracion" class="control-label col-sm-2">Duracion Tratamiento:</label>
                <div class="col-sm-10">
                    <input type="text" name="duracion" style="display: block;"/>
                </div>
            </div>
            <div class="form-group">    
                <label for="sala" class="control-label col-sm-2">Sala:</label>
                <div class="col-sm-10">
                    <input type="text" name="sala" style="display: block;"/>
                </div>
            </div>
            <div class="col-sm-2">
                <input type="submit" value="Enviar" class="btn btn-success"/>
            </div>
	</form>

	<a href="index.jsp" class="btn btn-primary">Regresar al Inicio</a>
</body>
</html>
