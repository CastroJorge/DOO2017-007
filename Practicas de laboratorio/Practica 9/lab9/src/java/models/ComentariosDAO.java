
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
    public void insertar(ComentariosPOJO comentario){
       try{
           abrirConexion();
           String sqlInsert = "insert into COMENTARIOS values ('" + comentario.getNombre()+ "','" + comentario.getComentario() + "')";
           Statement statement = conexion.createStatement();
           statement.executeUpdate(sqlInsert);
           cerrarConexion();
       }catch(Exception ex){
       }
    }
    
    /**
     *
     * @param pojo
     * @return
     */
    public ArrayList buscar(ComentariosPOJO pojo){
        ArrayList<ComentariosPOJO> comentarios = new ArrayList();
        try{
            abrirConexion();
            String sqlBuscar = "select * from COMENTARIOS where NOMBRE = '" + pojo.getNombre() + "' and COMENTARIO like '%" + pojo.getComentario() + "%'";            
            Statement statement = conexion.createStatement();
            ResultSet result = statement.executeQuery(sqlBuscar);
            while(result.next()){
                String nombre = result.getString("Nombre");
                String comentario = result.getString("Comentario");
                ComentariosPOJO coment = new ComentariosPOJO();
                coment.setNombre(nombre);
                coment.setComentario(comentario);
                comentarios.add(coment);
            }
            cerrarConexion();
        }catch(Exception ex){
        }
        return comentarios;
    }
}
