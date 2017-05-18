/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package films;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 */
public class FilmsDAO {

    private Connection conexion;

    private void abrirConexion() throws SQLException, IOException {
        String dbURI;
        dbURI = "jdbc:derby://localhost:1527/BIBLIOTECA";
        Properties p = new Properties();
        
        p.load(getClass().getResourceAsStream("propiedades.properties"));            
        
        String usuario = p.getProperty("username");
        String password = p.getProperty("password");
        
        conexion = DriverManager.getConnection(dbURI, usuario, password);
    }

    private void cerrarConexion() throws SQLException {
        conexion.close();
    }
    
    public boolean loguearse(FilmsPOJO fPOJO) throws SQLException, IOException {
        ResultSet mensajes=null;
        
        boolean existe=false;
        try {
            abrirConexion();
            
            String nombre=fPOJO.getUsuario();
            String contraseña=fPOJO.getContraseña();
            
            String sql = "SELECT * FROM USUARIOS WHERE NOMBRE='" +nombre
                    + "' AND PASSWORD='" + contraseña  + "'";
            
            Statement stmt =conexion.createStatement();
            mensajes=stmt.executeQuery(sql);
            
            existe = mensajes.next();
                
            
            cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(FilmsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }
    //public List obtenerUsuario(FilmsPOJO fPOJO) throws SQLException, IOException{
       // ResultSet mensajes=null;
        
       // List beans =new ArrayList();
       // try {
           // abrirConexion();
            
//            String contraseña=fPOJO.getContraseña();
            
           // String sql = "SELECT * FROM USUARIOS WHERE NOMBRE='" +nombre
                  //  + "' AND PASSWORD='" + contraseña  + "'";
            
           // Statement stmt =conexion.createStatement();
           // mensajes=stmt.executeQuery(sql);
            
           // while(mensajes.next()){
               // String nom = mensajes.getString("NOMBRE");
                //FilmsPOJO bean = new FilmsPOJO();
               // bean.setUsuario(nom);
               // beans.add(bean);
            //}
                
            
            //cerrarConexion();
            
       // } catch (SQLException ex) {
          //  Logger.getLogger(FilmsDAO.class.getName()).log(Level.SEVERE, null, ex);
       // }
       // return beans;
   // }
    
    public void insertarUsuario(FilmsPOJO fPOJO) throws SQLException, IOException {

        try {
            abrirConexion();
            
            String sql="INSERT INTO USUARIOS VALUES ('" + fPOJO.getIdUsuario()  + "','"+ fPOJO.getContraseña() +  "','" + fPOJO.getUsuario()+ "')";
            
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
            
            cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(FilmsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List buscar(FilmsPOJO fPOJO, HttpSession session) throws SQLException, IOException {
        ResultSet peliculas=null;
        List beans = new ArrayList();
        try {
            abrirConexion();
            
            String usuario = (String)session.getAttribute("USUARIO");
            
            
            String sql="SELECT * FROM ARTICULOS WHERE TITULO LIKE '%" + fPOJO.getTitulo()
                    + "%'";
                    //AND USUARIO='" +  usuario  + "'"
            
            Statement stmt =conexion.createStatement();
            peliculas=stmt.executeQuery(sql);
            
            while(peliculas.next()){
                String titulo = peliculas.getString("TITULO");
                String idArt =peliculas.getString("ID_ARTICULO");
                String descripcion=peliculas.getString("DESCRIPCION");
                String url_Imagen = peliculas.getString("URL_IMAGEN");
                //Corregir en base de datos - ID CATEGORIA CAMBIAR A VARCHAR
                String idCat = peliculas.getString("ID_CATEGORIA");
                
                
                FilmsPOJO bean =new FilmsPOJO();
                
                bean.setIdCategoria(idCat);
                bean.setUrl_Imagen(url_Imagen);
                bean.setDescripcion(descripcion);
                bean.setIdArticulo(idArt);
                bean.setUsuario(usuario);
                bean.setTitulo(titulo);
                
                beans.add(bean);
                
            }
            
            cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(FilmsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return beans;
    }
    
    public List buscarArtDUsuario(FilmsPOJO fPOJO, HttpSession session,String usuario) throws SQLException, IOException {
        ResultSet peliculas=null;
        List beans = new ArrayList();
        try {
            abrirConexion();
            
            String sql="SELECT * FROM ARTICULOS WHERE USUARIO='" +  usuario  + "'";
            
            Statement stmt =conexion.createStatement();
            peliculas=stmt.executeQuery(sql);
            
            while(peliculas.next()){
                String titulo = peliculas.getString("TITULO");
                String idArt =peliculas.getString("ID_ARTICULO");
                String descripcion=peliculas.getString("DESCRIPCION");
                String url_Imagen = peliculas.getString("URL_IMAGEN");
                //Corregir en base de datos - ID CATEGORIA CAMBIAR A VARCHAR
                String idCat = peliculas.getString("ID_CATEGORIA");
                
                
                FilmsPOJO bean =new FilmsPOJO();
                
                bean.setIdArticulo(idArt);
                bean.setTitulo(titulo);
                bean.setDescripcion(descripcion);
                bean.setUrl_Imagen(url_Imagen);
                bean.setIdCategoria(idCat);
                bean.setUsuario(usuario);
                
                beans.add(bean);
                
            }
            
            cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(FilmsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return beans;
    }
    
   public void insertarArticulo(FilmsPOJO fPOJO, HttpSession sesion) throws SQLException, IOException {

        try {
            abrirConexion();
            
            String usuario = (String)sesion.getAttribute("USUARIO");
            String sql = "INSERT INTO ARTICULOS VALUES ('" + fPOJO.getIdArticulo() + "','" + fPOJO.getTitulo() + "','" + fPOJO.getDescripcion() + "','" + fPOJO.getUrl_Imagen() + "','" + fPOJO.getCategoria() + "','" + usuario + "')";
            
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
            cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(FilmsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
