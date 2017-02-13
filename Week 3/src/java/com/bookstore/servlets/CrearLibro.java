/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jorge
 */
public class CrearLibro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            response.setContentType("text/html;charset=UTF-8");

            try (PrintWriter out = response.getWriter()) {

                //El parámetro enviado a getParameter() deberá coincidir con la propiedad name del elemento de HTML
                //Ejemplo: <input type="text" name="variable" /> coincide con la siguiente línea:
               
                String name = request.getParameter("name");
                String precio = request.getParameter("precio");
                String isbn = request.getParameter("isbn");
                String fecha = request.getParameter("fecha");
                String genero = request.getParameter("genero");
                String editorial = request.getParameter("editorial");
                String autor = request.getParameter("autor");
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");

                out.println("<title>Información del Libro</title>");
                out.println("<link href=\"static/hojaestilo.css\" rel=\"stylesheet\" />");

                out.println("</head>");
                out.println("<body>");

                out.println("<h1>Título</h1>");
                out.println("<p>Nombre: " + request.getParameter("name") + " </p>");
                out.println("<p>Precio: " + request.getParameter("precio") + " </p>");
                out.println("<p>ISBN: " + request.getParameter("isbn") + " </p>");
                out.println("<p>Fecha: " + request.getParameter("fecha") + " </p>");
                out.println("<p>Genero: " + request.getParameter("genero") + " </p>");
                out.println("<p>Editorial: " + request.getParameter("editorial") + " </p>");
                out.println("<p>Autor: " + request.getParameter("autor") + " </p>");

                out.println("</body>");
                out.println("</html>");
            }
        }

}