/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Jorge Eduardo Castro 1640167
 */
public class Autentificacion {
    
    public static boolean autentificar(String usuario, String password){
        User u = new User();
        boolean isTrue;
        
        if(u.usuario.equals(usuario) && u.password.equals(password)){
            isTrue = true;
        }
        else{
            isTrue = false;
        }
        
        return isTrue;
    }
    
}
