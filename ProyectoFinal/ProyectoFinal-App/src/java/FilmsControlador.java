/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import films.FilmsDAO;
import films.FilmsPOJO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juan José
 */
public class FilmsControlador extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {

            String accion = request.getParameter("accion");

            if (accion.equals("loguear")) {
                String usuario = "";
                usuario = request.getParameter("usuario");
                String password = "";
                password = request.getParameter("password");
                int hashPass = password.hashCode();
                String pass = String.valueOf(hashPass);
 
                FilmsPOJO fPOJO = new FilmsPOJO();
                FilmsDAO fDAO = new FilmsDAO();
                if ((usuario != "") && (password != "")) {

                    fPOJO.setUsuario(usuario);
                    fPOJO.setContraseña(pass);

                    if (fDAO.loguearse(fPOJO)) {
                        HttpSession session = request.getSession();
                        String nombre = request.getParameter("usuario");
                        List lista2 = fDAO.buscarArtDUsuario(fPOJO, session, nombre);
                        session.setAttribute("peliculasDUsuario", lista2);
                        session.setAttribute("USUARIO", nombre);
                        response.sendRedirect("consulta.jsp");
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                }
            } else if (accion.equals("registrarUsuario")) {
                String usuario = request.getParameter("usuario");
                String nombre = request.getParameter("nombre");
                String password = request.getParameter("password");
                int hashPass = password.hashCode();
                String pass = String.valueOf(hashPass);

                FilmsPOJO fPOJO = new FilmsPOJO();
                FilmsDAO fDAO = new FilmsDAO();

                fPOJO.setIdUsuario(usuario);
                fPOJO.setUsuario(nombre);
                fPOJO.setContraseña(pass);

                fDAO.insertarUsuario(fPOJO);

                response.sendRedirect("login.jsp");

            } else if (accion.equals("buscar")) {
                String titulo = request.getParameter("busqueda");

                FilmsPOJO fPOJO = new FilmsPOJO();
                FilmsDAO fDAO = new FilmsDAO();

                fPOJO.setTitulo(titulo);

                HttpSession sesion = request.getSession();
                
                System.out.println(titulo);

                List lista = fDAO.buscar(fPOJO, sesion);
                sesion.setAttribute("peliculas", lista);
                sesion.setAttribute("busqueda", titulo);

                response.sendRedirect("consulta.jsp");
            } else if (accion.equals("registrarArticulo")) {
                String clave = request.getParameter("clave");
                String titulo = request.getParameter("titulo");
                String descripcion = request.getParameter("descripcion");
                String idCategoria = request.getParameter("IdCategoria");
                //int categoria=Integer.parseInt(idCateg);
                String url = request.getParameter("url");

                FilmsPOJO fPOJO = new FilmsPOJO();
                FilmsDAO fDAO = new FilmsDAO();

                fPOJO.setIdArticulo(clave);
                fPOJO.setTitulo(titulo);
                fPOJO.setDescripcion(descripcion);
                fPOJO.setCategoria(idCategoria);
                fPOJO.setUrl_Imagen(url);

                HttpSession sesion = request.getSession();

                fDAO.insertarArticulo(fPOJO, sesion);

                String nombre = (String)sesion.getAttribute("USUARIO");
                List lista2 = fDAO.buscarArtDUsuario(fPOJO, sesion, nombre);
                sesion.setAttribute("peliculasDUsuario", lista2);

                response.sendRedirect("consulta.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }

        } catch (SQLException ex) {
            Logger.getLogger(FilmsControlador.class.getName()).log(Level.SEVERE, null, ex);
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
