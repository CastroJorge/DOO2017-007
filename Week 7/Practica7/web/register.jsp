<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
       <body>
        <h1>Iniciar sesion</h1>
        <p><a href="login.jsp">Iniciar Sesion</a></p>
        
        <form action="Register" method="post"><br><br>
            Nombre de Usuario: <input type="text" name="username"><br><br>
            Nombre: <input type="text" name="name"><br><br>
            Apellidos: <input type="text" name="lastName"><br><br>
            Email: <input type="text" name="email"><br><br>
            Contraseña: <input type="password" name="password1"><br><br>
            Confirma contraseña <input type="password" name="password2"><br><br>
            <input type="submit" value="Entrar"></p>
        </form>
    </body>
</html>
