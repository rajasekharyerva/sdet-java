package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private static DBHelper instance;
    private Connection connection;

    // Private constructor to prevent instantiation
    private DBHelper() {
        try {
            // Replace with your DB credentials
            String url = "jdbc:mysql://localhost:3306/your_database";
            String username = "your_username";
            String password = "your_password";

            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Public method to get the singleton instance
    public static DBHelper getInstance() {
        if (instance == null) {
            synchronized (DBHelper.class) {
                if (instance == null) {
                    instance = new DBHelper();
                }
            }
        }
        return instance;
    }

    // Method to get the connection
    public Connection getConnection() {
        return connection;
    }

    // Close the connection (if needed)
    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
