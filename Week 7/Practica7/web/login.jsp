<%
    if(session.getAttribute("username") != null)
        response.sendRedirect("profile.jsp");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <header>
        Iniciar sesion
    </header>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            
        </title>
    </head>
    <body>
        <h1> Bienvenido Inicie Sesion para Continuar</h1>
        <form action="LoginController" method="POST">
            Usuario: <input type="text" name="Usuario"><br><br>
            Contraseña: <input type="password" name="Contrasena"><br><br>
            <input type="submit" value="Iniciar sesión">
            <h1> <a href="register.jsp">Registrate</a></h1>
            
        </form>
        
    </body>
</html>
