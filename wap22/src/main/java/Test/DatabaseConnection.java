package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
  
// This class can be used to initialize the database connection
public class DatabaseConnection {
    public static Connection initializeDatabase()
        throws SQLException, ClassNotFoundException
    {
        // Initialize all the information regarding
        // Database Connection
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "\"jdbc:mysql://localhost/\"";
        // Database name to access
        String dbName = "wap_opg";
        String dbUsername = "root";
        String dbPassword = "google666";
  
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/"+"wap_opg"+"?serverTimezone=UTC","root","google666");
        return con;
    }
}