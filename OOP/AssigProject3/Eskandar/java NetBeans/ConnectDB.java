package healthconnect;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Eskandar Atrakchi
 */
public class ConnectDB {
    //singleton design pattern 
    //private attribute 
    //private constructor 
    //public static method 
    
    private static Connection conn = null;
    
    //priate contstructor
    private ConnectDB() {
    }
    
    //static block to initilise values with predifined values 
    static {
        //existed DB in mysql for storing user data
        String url = JOptionPane.showInputDialog("Please enter the url to MySQL.");//"jdbc:mysql://127.0.0.1:3306/OOP";
        String user = JOptionPane.showInputDialog("Please enter the username of MySQL.");//"root";
        String password = JOptionPane.showInputDialog("Please enter the password of MySQL.");//"0723524754Aa.";
        try {
            conn = DriverManager.getConnection (url, user, password);
        }
        catch (SQLException e ) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null , "The error is: " + e.getMessage());
        }
    }
    //method to return the conn variable
    //I call this method whenever I want to get the conn variable
    public static Connection getConnection () {
        return conn;
    }
}
