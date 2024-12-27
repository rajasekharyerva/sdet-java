package selenium.gd;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectToDB {
    @Test
    public void validateEmployeeData() throws IOException {
        List<Employee> employeeList = connectToDatabase();
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        String userDir = System.getProperty("user.dir");
        List<Employee> employeeData = objectMapper.readValue(new File(userDir + "/src/test/java/selenium/gd/employee.json"), Employees.class).getEmployee();

    }

    public List<Employee> connectToDatabase() {
        String url = "jdbc:mysql://localhost:3306/my_database";
        String username = "user";
        String password = "user_password";
        Connection connection;
        String sqlQuery = "SELECT emp_no, first_name, last_name  FROM employee;";
        List<Employee> employeeList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement pst = connection.prepareStatement(sqlQuery);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmpNo(rs.getInt("emp_no"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Employees employees = new Employees();
        employees.setEmployee(employeeList);

        return employeeList;
    }
}
