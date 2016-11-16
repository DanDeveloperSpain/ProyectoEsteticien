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
        <title>JSP Page</title>
    </head>
<body>

	<h1>Agregar Tratamiento</h1>
	
	<form action="AltaTratamiento" method="post">
		<input type="hidden" name="accion" value="agregar"/>
	
		<label for="nombre">Nombre Tratamiento:</label>
		<input type="text" name="nombre" style="display: block;" />
		
		<label for="precio">Precio Tratamiento:</label>
		<input type="text" name="precio" style="display: block;"/>
		
		<label for="duracion">Duracion Tratamiento:</label>
		<input type="text" name="duracion" style="display: block;"/>
                
                <label for="sala">Sala:</label>
		<input type="text" name="sala" style="display: block;"/>
		
		<input type="submit" value="Enviar" />
	</form>

	<a href="index.jsp">Regresar al Inicio</a>
</body>
</html>
