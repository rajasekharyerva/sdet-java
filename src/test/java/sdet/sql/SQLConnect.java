package sdet.sql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;

public class SQLConnect {
    private static final Logger logger = LoggerFactory.getLogger(SQLConnect.class);

    // Database URL, username, and password
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/my_database";
    private static final String USER = "root";
    private static final String PASSWORD = "root_password";

    @Test
    public void getEmployeeCount() {
        int empCount=0;
        Connection connection = null;

        try {
            // Establishing a connection to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database.");

            // Example of a SELECT query
            String sql = "SELECT COUNT(*) AS employee_count FROM employeeV2";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Executing the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Processing the results
            while (resultSet.next()) {
                empCount = resultSet.getInt("employee_count");
            }

            // Clean up
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Closing the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        logger.info("Employee Count: {}", empCount);
        Assert.assertTrue(empCount > 6, "Employee count should be greater than 5");

    }
}

