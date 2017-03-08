<%
    if(session.getAttribute("Usuario") != null)
           response.sendRedirect("success.jsp");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Iniciar Sesion</h1>
        
        <form action="Lab05_LoginController" method="POST">
            <label>Usuario: </label>
            <input type="text" name="username"/><br><br>
            <label>Contraseña: </label>
            <input type="password" name="password"/>
            
            <input type="submit" value="Iniciar Sesión"/>                        
        </form>
        
    </body>
</html>
