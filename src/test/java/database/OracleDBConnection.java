package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleDBConnection {
    public static void main(String[] args) {
        // Database credentials
        String dbURL = "jdbc:oracle:thin:@//localhost:1521/orcl";
        String username = "your_username";
        String password = "your_password";

        // Connection, Statement, and ResultSet
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish the connection
            connection = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Connected to Oracle Database!");

            // Create a statement
            statement = connection.createStatement();

            // Execute a query
            String query = "SELECT * FROM your_table";
            resultSet = statement.executeQuery(query);

            // Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Clean up resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

