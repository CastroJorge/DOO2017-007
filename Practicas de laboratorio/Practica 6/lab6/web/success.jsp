<%
    if(session.getAttribute("Usuario") == null)
        response.sendRedirect("login.jsp");
    
    //Color
    
    String color = "";
    Cookie cookie = null;
    Cookie[] cookies = request.getCookies();
    
    if( cookies != null ) {
          for (int i = 0; i < cookies.length; i++){
             cookie = cookies[i];
             if(cookie.getName( ) == "color"){
                 color = cookie.getValue();
             }
          }
      }

%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body style = "background-color: <%=color%>">
        
        <h1>Bienvenido <%= session.getAttribute("Usuario") %></h1>
        
        <form action="ProfileController" method="POST">
            <select name="color">
                <option value="Blue">Blue</option>
                <option value="Purple">Purple</option>
                <option value="Black">Black</option>
            </select>
            <input type="submit" value="Guardar"/>
        </form>
        
        <a href="LogOutController">Cerrar sesion</a>
                
    </body>
</html>