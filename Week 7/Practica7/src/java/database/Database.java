package database;
import java.io.*;
import java.text.ParseException;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.*;
import week7.models.User;

public class Database {
       
    private static String getPathDatabase() {
        return "C:\\Users\\Jorge\\Desktop\\week7\\src\\java\\database\\Newjson.json";
    }
    private static boolean setJsonObject(String name, String lastName, String username, String password){
        JSONObject  obj = new JSONObject();

       //Solo guarda un valor
       obj.put("Usuario",username);

       String rutaJson = getPathDatabase(); //llamada a método anterior getPathDatabase

       try (FileWriter file = new FileWriter(rutaJson)) {
               file.write(obj.toJSONString());

               return true;
       }
       catch(IOException ioext) {
           return false;
       }
    }

    private static JSONObject getJsonObject() {

        try {
            String rutaJson = getPathDatabase();
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("C:\\Users\\Jorge\\Desktop\\week7\\src\\java\\database\\Newjson.json"));

          
            JSONObject jsonObject =  (JSONObject) obj;

            return jsonObject;
        }
        catch(IOException ioext) {
            return null;
        }
        catch(ParseException pext) {
            return null;
        }
    }
  
    public static User getUserByUsername(String username) {
        User user;

        JSONObject jsonObject = getJsonObject();
        if(jsonObject != null) {
            String nameDb = (String) jsonObject.get("Nombre");
            String lastNameDb = (String) jsonObject.get("Apellidos");
            String usernameDb = (String) jsonObject.get("Usuario");
            String passwordDb = (String) jsonObject.get("Contraseña");
            
        
            if(username.equals(usernameDb)) {
                user = new User(nameDb, lastNameDb, usernameDb, passwordDb); //Completar con todas las propiedades del usuario
            }
            else {
                user = null;
            }

            return user;
        }
        else{
            return null;
        }
    }
    /*
    getUserByUsernamePassword(username:String, password:String):User: Devuelve un objeto 
    de tipo User con la información del archivo JSON. Ejemplo:
    */
    
    public static User getUserByUsernamePassword(String username, String password){
        User user;

        JSONObject jsonObject = getJsonObject(); //Llamáda a método

        if(jsonObject != null) {
            String nameDb = (String) jsonObject.get("Nombre");
            String lastNameDb = (String) jsonObject.get("Apellidos");
            String usernameDb = (String) jsonObject.get("Usuario");
            String passwordDb = (String) jsonObject.get("Contraseña");

            if(username.equals(usernameDb) && password.equals(passwordDb)) {
                user = new User(nameDb, lastNameDb, usernameDb, passwordDb); //Completar con todas las propiedades del usuario
            }
            else {
                user = null;
            }

            return user;
        }
        else{
            return null;
        }
    }
    public static boolean setUser(String name, String lastName, String username, String password) {

        boolean isSetup = setJsonObject(name, lastName, username, password);

        return isSetup;
    }
    
}
