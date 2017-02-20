<%-- 
    Document   : login
    Created on : Feb 19, 2017, 11:10:34 PM
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido</h1>
        <form ACTION="LoginController">
            Usuario <input type="text" value="" name="usuario"><br><br>
            Contraseña <input type="password" value="" name="contraseña"><br><br>
            <input type="submit" value="Login">
            
        </form>

    </body>
</html>
