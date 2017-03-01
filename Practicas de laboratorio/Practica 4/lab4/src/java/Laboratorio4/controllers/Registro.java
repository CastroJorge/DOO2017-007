/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratorio4.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import Laboratorio4.models.Authentication;
import Laboratorio4.models.User;

/**
 *
 * @author Jorge Eduardo Castro Tristan 1640167
 */
public class Registro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
            RequestDispatcher dispatcher = null;
        
            String usuario = request.getParameter("usuario");
            String contrasena = request.getParameter("contrasena");

        boolean isValidUser =  Authentication.authenticate(usuario, contrasena);

        if(isValidUser) {

            //Construye instancia del modelo User
            User user = new User();

            //Construye parámetro para enviar a la vista success.jsp
            request.setAttribute("Usuario", user.obtenerUsuario());
            request.setAttribute("Contraseña", user.obtenerContrasena());
            //Se define a donde se enviará el objeto request y response.
            dispatcher = request.getRequestDispatcher("success.jsp");
            try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Registro</h1><br><br>");
            out.println("<label>Usuario: " + user.obtenerUsuario() + "</label><br><br>");
            out.println("<label>Email: " + user.obtenerEmail() + "</label><br><br>");
            out.println("<label>Nombre: " + user.obtenerNombre() + "</label><br><br>");
            out.println("<label>Apellidos: " + user.obtenerApellidos() + "</label><br><br>");
            out.println("<label>Ocupacion: " + user.obtenerOcupacion() + "</label><br><br>");
            }
            dispatcher.forward(request, response);
        }else {
        //Si el usuario es inválido, reedireccionamos la petición hacia error.jsp
        response.sendRedirect("error.jsp");
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
