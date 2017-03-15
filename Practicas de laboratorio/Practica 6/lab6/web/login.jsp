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
        
        <form action="LoginController" method="POST">
            Usuario: <input type="text" name="txt-username"/><br><br>
            Contraseña: <input type="password" name="txt-password"/> <br><br>
            <input type="submit" value="Login"/>                        
        </form>
        
    </body>
</html>
