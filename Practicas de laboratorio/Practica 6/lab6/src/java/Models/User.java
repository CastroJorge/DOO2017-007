
package Models;


public class User {
    
    public String usuario;
    public String password;
    public String email;
    public String nombre;
    public String apellidos;
    public String ocupacion;
    
    public User(){
        
        usuario = "Jorge";
        password = "123";
        email = "ecastrojorge@hotmail.com";
        nombre = "Jorge Eduardo";
        apellidos = "Castro Tristan";
        ocupacion = "Estudiante";
        
    }
    
    public String toString(){
        return "\n" + usuario + "\n" + email + "\n" + nombre + "\n" + apellidos + "\n" + ocupacion + "\n";
    }
    
    public String obtenerUsuario()
    {
        return usuario;
    }
    
    public String obtenerContrasena()
    {
        return password;
    }
    
    
}
