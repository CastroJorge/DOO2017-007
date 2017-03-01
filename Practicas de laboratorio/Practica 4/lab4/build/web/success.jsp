<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        out.println("<label>Usuario: " + user.obtenerUsuario() + "</label><br><br>");
        out.println("<label>Email: " + user.obtenerEmail() + "</label><br><br>");
        out.println("<label>Nombre: " + user.obtenerNombre() + "</label><br><br>");
        out.println("<label>Apellidos: " + user.obtenerApellidos() + "</label><br><br>");
        out.println("<label>Ocupacion: " + user.obtenerOcupacion() + "</label><br><br>");

    </body>
</html>
