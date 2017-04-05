package models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *
 * @author Jorge Eduardo Castro Tristan 1640167
 */
public class Log {
    private final String fileName;
    private static Log instance;
    
    private Log(String fileName){
        this.fileName=fileName;
    }
    
    public static Log getInstance(String fileName){
        if(instance == null)
        {
            instance = new Log("C:\\Users\\Jorge\\Desktop\\Log.txt");
        }
        return instance;
    }
    
    public void write(String message){
        try{
            try (BufferedWriter br = new BufferedWriter(new FileWriter(fileName, true))) { 
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            Calendar cal = Calendar.getInstance();

            String data = "\n" + dateFormat.format(cal.getTime()) + ": " + message ;
            br.write(data);
            } 
        }catch(Exception ex){
        }
    }
}
