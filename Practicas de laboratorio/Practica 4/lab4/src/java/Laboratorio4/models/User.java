/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratorio4.models;

/**
 *
 * @author Jorge Eduardo Castro Tristan 1640167
 */
public class User {
    private String usuario;
    private String contrasena;
    private String email;
    private String nombre;
    private String apellidos;
    private String ocupacion;
    
    
    public User()
    {
        usuario="Jorge";
        contrasena="123";
        email="ecastrojorge@hotmail.com";
        nombre="Jorge Eduardo";
        apellidos="Castro Tristan";
        ocupacion="Estudiante";
    }
    
    public String obtenerUsuario()
    {
        return usuario;
    }
    
    public String obtenerContrasena()
    {
        return contrasena;
    }
    
    public String obtenerEmail()
    {
        return email;
    }
    
    public String obtenerNombre()
    {
        return nombre;
    }
    
    public String obtenerApellidos()
    {
        return apellidos;
    }
    
    public String obtenerOcupacion()
    {
        return ocupacion;
    }
}
