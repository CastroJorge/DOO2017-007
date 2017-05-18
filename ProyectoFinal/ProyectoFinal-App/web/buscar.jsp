


<%@page import="java.util.List"%>
<%@page import="films.FilmsPOJO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar</title>
    </head>
    <body background="fondo.jpg">
        <div align="center">
            <% String usuario=(String) session.getAttribute("USUARIO");%>
            Hola <input type="tag"<%=usuario %>
            <h1>Mi biblioteca de peliculas</h1>
            <form action="" method="POST">
                Buscar:<input type="text" maxlength="50" name="pelicula">

                <input type="submit" value="Buscar">
                <input type="hidden" name="accion" value="buscar">
            </form>

        </div>
        
        <div align="center">
        <table border="1">
            <tr>
                <th>Clave</th>
                <th>Título</th>
                <th>Descipción</th>
                <th> Categoría</th>
                <th>Acciones </th>
            </tr>


            <%
            
            
                for(int x=0;x<10;x++){
                    FilmsPOJO fPOJO = new FilmsPOJO() ;


            %>
            <tr>
                <td> <%=fPOJO.getIdArticulo()%> </td>
                <td> <%=fPOJO.getTitulo()%> </td>
                <td> <%=fPOJO.getDescripcion()%> </td>
                <td> <%=fPOJO.getCategoria()%> </td>
                <td><a href="detalles.jsp"> Detalles </a> </td>
            </tr>

            <%
                        }%>

        </table>
                        <a href="registroarticulo.jsp">Registrar Articulo</a>
        </div>
        </body>
</html>
