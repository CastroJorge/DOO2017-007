
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jorge Eduardo Castro Tristan 1640167
 */
public class ComentariosDAO {
    private Connection conexion;
    private void abrirConexion() throws SQLException{
        String dbURI = "jdbc:derby://localhost:1527/Comentarios";
        String username = "fcfm";
        String password = "lsti01";
        conexion = DriverManager.getConnection(dbURI, username, password);
    }
    private void cerrarConexion() throws SQLException{
        conexion.close();
    }
    public void insertar(ComentariosPOJO comm){
       try{
           abrirConexion();
           String sqlInsert = "insert into COMENTARIOS values ('"+comm.getNombre()+"','"+comm.getComentario()+"')";
           Statement stmt = conexion.createStatement();
           stmt.executeUpdate(sqlInsert);
           cerrarConexion();
       }catch(SQLException ex){
            System.out.println("Hubo un problema, intente de nuevo.");
       }
    }
    public ArrayList buscar(ComentariosPOJO poj){
        ResultSet regis ;
        ArrayList<ComentariosPOJO> comentarios = new ArrayList();
        try{
            abrirConexion();
            String sqlBuscar = "select * from COMENTARIOS where NOMBRE = '" + poj.getNombre()+"' and COMENTARIO like '%"+poj.getComentario()+ "%'";            
            Statement stmt = conexion.createStatement();
            ResultSet mensajes = stmt.executeQuery(sqlBuscar);
            while(mensajes.next()){
                String nombre = mensajes.getString("Nombre");
                String comentario = mensajes.getString("Comentario");
                ComentariosPOJO comment = new ComentariosPOJO();
                comment.setNombre(nombre);
                comment.setComentario(comentario);
                comentarios.add(comment);
            }
            cerrarConexion();
        }catch(SQLException ex){
            System.out.println("Hubo un problema, intente de nuevo.");
        }
        return comentarios;
    }
    
}
