package dbprogramming2;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class LAB15 {

    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root";
        String password = "Merlin_2";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, username, password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM student";
            ResultSet results = statement.executeQuery(sql);
            ResultSetMetaData rsMetaData= results.getMetaData();
            System.out.println(rsMetaData.getColumnCount());
            
            for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                System.out.printf("%-15s\t",rsMetaData.getColumnName(i)); 
            }
            System.out.println();
            
            while (results.next()) {
                for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                    System.out.printf("%-15s\t",results.getString(i));       
                }
                System.out.println();       
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LAB15.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LAB15.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
