
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresa :D </title>
    </head>
    <body>
    <center>
        <h1>Moviefy</h1>

        <h2>Ingresa ya para agregar tus peliculas o ver tu colección </h2>
        <img src="photo.jpeg"/>  

        <form action="FilmsControlador" method="POST">
            <a> Usuario (ID): <input type="text" name="usuario"> </a>
            <a> Contraseña:<input type="password" name="password"> </a>
            <input type="submit" name="enviar" value="Loguearse">
            <input type="hidden" name="accion" value="loguear">
        </form>
        
        <h2> Si aún no tienes cuenta, ¿que esperas? <a  href="registro.jsp">¡Registrate!</a> </h2>
    </center>
</body>
</html>
