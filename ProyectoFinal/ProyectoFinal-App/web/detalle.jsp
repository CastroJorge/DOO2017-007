

<%@page import="films.FilmsPOJO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalles de la pelicula</title>
    </head>
    <body>
         <% if (session != null) {
                String usuario = (String) session.getAttribute("USUARIO");
                if (usuario != null) {
        %>
        Hola <%=usuario%>
        <%} else {
                        response.sendRedirect("login.jsp");
                    }%>
        
        <table>
            <tr><%FilmsPOJO pojo=new FilmsPOJO();%>
                <th><%=request.getParameter("titulo") %></th>
                <th></th>
                <th></th>
            </tr>
            <tr>
                <td> Clave:  </td>
                <td><%=request.getParameter("idArt")%></td>
                <td></td>
            </tr>
            <tr>
                <td>Título:</td>
                <td><%=request.getParameter("titulo")%></td>
                <td> <img src="<%=request.getParameter("url")%>"> </td>
            </tr>
            <tr>
                <td>Descipción:</td>
                <td><%=request.getParameter("descripcion") %></td>
                <td></td>
            </tr>
        </table>
        
        Genero: <select name="categoria">
            <option value="animacion">Animación</option> 
            <option value="ciencia" selected>Ciencia Ficción</option>
            <option value="drama">Drama</option>
            <option value="comedia">Comedia</option>
        </select>

        <br>
        <br>
        <input type="button" name="eliminar" value="Eliminar">
        <input type="button" name="guardar" value="Guardar">
<% } else {
            response.sendRedirect("login.jsp");
        }%>
    </body>
</html>
