package dbprogramming2;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB9 {

    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        String password = "Merlin_2";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, username, password);
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO student(studentID,firstName,lastName,email,deptID) "
                    + "VALUES('111111','AAAA','BBBB','aaaa@gmail.com','IT')";
            statement.executeUpdate(sql);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LAB9.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LAB9.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
