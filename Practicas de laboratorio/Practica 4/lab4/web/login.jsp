<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro</h1>
        <form action="Registro" method="POST">
            <label>Usuario</label>
            <input type="text" name="usuario"/>
            <br/>
            <br/>
            <label>Contraseña</label>
            <input type="password" name="contrasena"/>
            <br/>
            <br/>
            <input type="submit" value="Iniciar sesion"/>
        </form>
    </body>
</html>
