package dbprogramming2;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

public class LAB12 {


     public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        String password = "Merlin_2";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, username, password);
            
            String sql = "INSERT INTO student(studentID,firstName,lastName,email,deptID) "
                    + "VALUES(?,?,?,?,?)";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "111111");
            preparedStatement.setString(2, "Phakphum");
            preparedStatement.setString(3, "Phrajrern");
            preparedStatement.setString(4, "PP@gmail.com");
            preparedStatement.setString(5, "IT");
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LAB12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LAB12.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
