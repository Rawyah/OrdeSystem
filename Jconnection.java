
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Jconnection {
    public static Connection conDB()
    {
        try{
             Class.forName("com.mysql.jdbc.Driver");
             Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/lightningpizza?zeroDateTimeBehavior=convertToNull","root","");
             System.out.println("Connected");
             return conn;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
