
package hotel.management.system.controlador.conexion;
import java.sql.*;

public class Conn {
    
    Connection c;
    public Statement s;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","001001");
            s = c.createStatement();
        }
        catch (Exception e){
        e.printStackTrace();
        }
    }    
}

