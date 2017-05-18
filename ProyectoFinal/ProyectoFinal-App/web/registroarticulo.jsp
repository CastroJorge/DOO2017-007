

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head  > 
        <style type="text/css">
    html, body {
        height: 100%;
        width: 100%;
        padding: 0;
        margin: 0;
    }
 
    #full-screen-background-image {
        z-index: -999;
        width: 100%;
        height: auto;
        position: fixed;
        top: 0;
        left: 0;
    }
</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de pelicula</title>
    </head>
    <body >
         <% if (session != null) {
                String usuario = (String) session.getAttribute("USUARIO");
                if (usuario != null) {
        %>
        Hola <%=usuario%>
        <%} else {
                        response.sendRedirect("login.jsp");
                    }%>
        <img alt="full screen background image" src="fondo.jpg" id="full-screen-background-image" />
        <div align="center">
            <form action="FilmsControlador" method="POST">
                <h1>Clave de pelicula (la inicial de tu nombre y 5 digitos a tu elección):</h1><input type="text" maxlength="50" name="clave"  ><br> 
                
                    <h1> Título:</h1><input type="text" maxlength="50" name="titulo">
                <br>
                
                    
                    
                    <h1> Descripción</h1><textarea name="descripcion" rows="10" cols="50"  ></textarea><br>
                    
                    <h1>Género:</h1><select name="IdCategoria">
                    <option value="1111">Animación</option> 
                    <option value="2222" selected>Ciencia Ficción</option>
                    <option value="3333">Drama</option>
                    <option value="4444">Comedia</option>
                
                
                </select> 
                
                
                <h1>URL de una imagen de la pelicula</h1><input type="text" maxlength="99" name="url"><br>


                <input type="submit" name="guardar" value="Guardar">
                <input type="hidden" name="accion" value="registrarArticulo">
            </form>
        </div>
        <% }else {
            response.sendRedirect("login.jsp");
        }%>

    </body>
</html>
