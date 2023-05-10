package dbprogramming2;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LAB13 {

    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        String password = "Merlin_2";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, username, password);
            String sql = "UPDATE student SET email=? WHERE studentID=?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "aaaa@kmutt.ac.th");
            preparedStatement.setString(2, "111111");
            preparedStatement.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LAB9.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LAB9.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    
}
