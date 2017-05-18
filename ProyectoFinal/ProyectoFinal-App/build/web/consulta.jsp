

<%@page import="films.FilmsPOJO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar</title>
    </head>
    <body background="fondo.jpg">
        <% if (session != null) {
                String usuario = (String) session.getAttribute("USUARIO");
                if (usuario != null) {
        %>
        Hola <%=usuario%>
        <%} else {
                response.sendRedirect("login.jsp");
            }%>
        <div align="center">
            <h1>Mi biblioteca de peliculas</h1>
            <form action="FilmsControlador" method="POST">
                Buscar:<input type="text" maxlength="100" name="busqueda">

                <input type="submit" value="Buscar">
                <input type="hidden" name="accion" value="buscar">
            </form>

            <% String busqueda = (String) session.getAttribute("busqueda");

                if (busqueda != null) {
                    List peliculas = (List) session.getAttribute("peliculas");
                    
            %>
            <div align="center">
                <table border="1">
                    <tr>
                        <th>Imagen</th>
                        <th>Clave</th>
                        <th>Título</th>
                        <th>Descripción</th>
                        <th>Categoría</th>
                        <th>Acciones </th>

                    </tr>
            </div>
            <% for (Object o : peliculas) {
                    FilmsPOJO fPOJO = (FilmsPOJO) o;%>
            <tr>
                <td> <img src="<%=fPOJO.getUrl_Imagen()%>" height="50px"> </td>
                <td> <%=fPOJO.getIdArticulo()%> </td>
                <td> <%=fPOJO.getTitulo()%> </td>
                <td> <%=fPOJO.getDescripcion()%> </td>
                <td> <%=fPOJO.getCategoria()%> </td>
                <td><form action="detalle.jsp" method="POST">Detalles
                        <input type="submit" value="Ver Detalles">
                        <input type="hidden" name="titulo" name="<%=fPOJO.getTitulo()%>">
                        <% System.out.println(fPOJO.getTitulo()); %>
                        <input type="hidden" name="idArt" name="<%=fPOJO.getIdArticulo()%>">
                        <input type="hidden" name="titulo" name="<%=fPOJO.getDescripcion()%>">
                        <input type="hidden" name="titulo" name="<%=fPOJO.getCategoria()%>"></form> </td>
            </tr>
            <% } %>
        </table>
        <%
        } else {
            List articulos = (List) session.getAttribute("peliculasDUsuario");
            if (articulos != null) {


        %>
        <div align="center">
            <table border="1">
                <tr>
                    <th>Imagen </th>
                    <th>Clave</th>
                    <th>Título</th>
                    <th>Descripción</th>
                    <th>Categoría</th>
                    <th>Acciones </th>

                </tr>

        </div>
        <%                for (Object o : articulos) {
                FilmsPOJO fPOJO = (FilmsPOJO) o;


        %>
        <tr>
            <td> <img src="<%=fPOJO.getUrl_Imagen()%>" height="50px"> </td>
            <td> <%=fPOJO.getIdArticulo()%> </td>
            <td> <%=fPOJO.getTitulo()%> </td>
            <td> <%=fPOJO.getDescripcion()%> </td>
            <td> <%=fPOJO.getCategoria()%> </td>
            <td><form action="detalle.jsp" method="POST">Detalles
                    <input type="submit" value="Ver Detalles">
                    <input type="hidden" name="titulo" name="<%=fPOJO.getTitulo()%>">
                    <input type="hidden" name="idArt" name="<%=fPOJO.getIdArticulo()%>">
                    <input type="hidden" name="descripcion" name="<%=fPOJO.getDescripcion()%>">
                    <input type="hidden" name="categoria" name="<%=fPOJO.getCategoria()%>">
                    <input type="hidden" name="url" name="<%=fPOJO.getUrl_Imagen()%>"></form> </td>
        </tr>
        <%
            }%>
    </table>

    <%  }
            }
            ;
        } else {
            response.sendRedirect("login.jsp");
        }
    %>
    <a href="registroarticulo.jsp">Registrar Articulo</a>

</body>
</html>
