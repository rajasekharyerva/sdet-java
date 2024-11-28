package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PostgresDBConnection {
    public static void main(String[] args) {
        // Database connection parameters
        String dbURL = "jdbc:postgresql://localhost:5432/testdb";
        String username = "postgres";
        String password = "your_password";

        // JDBC connection, statement, and result set
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establish connection
            connection = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Connected to PostgreSQL database!");

            // Prepare SQL query
            String query = "SELECT id, name FROM employees WHERE department = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "Engineering"); // Set the department dynamically

            // Execute the query and process the results
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
