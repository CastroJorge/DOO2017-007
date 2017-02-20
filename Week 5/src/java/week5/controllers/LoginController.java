/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5.controllers;

import javax.servlet.RequestDispatcher;
import week5.models.User;
import week5.models.Authentication;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Jorge Eduardo Castro Tristan 1640167
 * @author Jorge
 */
public class LoginController extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    //RequestDispatcher será la clase que nos apoyará a devolver
    //el valor hacia la vista
    RequestDispatcher dispatcher = null;

    //Se recupera la información del request
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");

    //Invoca al método authenticate para validar el usuario
    boolean isValidUser =  Authentication.authenticate(usuario, contraseña);

    if(isValidUser) {

        //Construye instancia del modelo User
        User user = new User(usuario, contraseña);

        //Construye parámetro para enviar a la vista success.jsp
        request.setAttribute("usuario", user.getUsername());

        //Se define a donde se enviará el objeto request y response.
        dispatcher = request.getRequestDispatcher("success.jsp");
        dispatcher.forward(request, response);
    }
    else {
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
