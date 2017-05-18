
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrate :D</title>
    </head>
    <body>
    <center>
        <img src="photo.jpeg"/>  
        <h1>¡Registrate para disfrutar gratis de tus peliculas completamente organizadas</h1>
        <form action="FilmsControlador" method="POST">
            Usuario(ID):<input type="text" name="usuario">
            Nombre:<input type="text" name="nombre">
            Contraseña:<input type="password" name="password">
            <input type="submit" name="enviar" value="Enviar">
            <input type="reset" name="limpiar" value="Limpiar">
            <input type="hidden" name="accion" value="registrarUsuario">
            
        </form>
        
        <h2> <a  href="login.jsp">Ingresa Ya!</a> </h2>
    </center>
        
    </body>
</html>
