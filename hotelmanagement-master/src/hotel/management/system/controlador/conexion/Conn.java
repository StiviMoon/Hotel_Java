
package hotel.management.system.controlador.conexion;
import java.sql.*;

public class Conn {
    
    Connection c;
    public Statement s;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","1004694736Dr*");
            s = c.createStatement();
        }
        catch (Exception e){
        e.printStackTrace();
        }
    }    
}

