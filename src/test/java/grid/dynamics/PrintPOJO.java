package grid.dynamics;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PrintPOJO {
    public static void main(String[] args) throws IOException {
        String Outerjson = "{\n" +
                "  \"employees\": {\n" +
                "    \"employee\": [\n" +
                "      {\n" +
                "        \"id\": \"1\",\n" +
                "        \"firstName\": \"Tom\",\n" +
                "        \"lastName\": \"Cruise\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"2\",\n" +
                "        \"firstName\": \"Maria\",\n" +
                "        \"lastName\": \"Sharapova\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"3\",\n" +
                "        \"firstName\": \"James\",\n" +
                "        \"lastName\": \"Bond\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";

        String empl0yee = "{\"employee\": [\n" +
                "      {\n" +
                "        \"id\": \"1\",\n" +
                "        \"firstName\": \"Tom\",\n" +
                "        \"lastName\": \"Cruise\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"2\",\n" +
                "        \"firstName\": \"Maria\",\n" +
                "        \"lastName\": \"Sharapova\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"3\",\n" +
                "        \"firstName\": \"James\",\n" +
                "        \"lastName\": \"Bond\"\n" +
                "      }\n" +
                "    ]}";

        String emp = "{\n" +
                "        \"id\": \"1\",\n" +
                "        \"firstName\": \"Tom\",\n" +
                "        \"lastName\": \"Cruise\"\n" +
                "      }";


        ObjectMapper obj = new ObjectMapper();
        System.out.println(System.getProperty("user.dir"));
        EmployeeContainer jsonObj = obj.readValue(new File(System.getProperty("user.dir") + "/src/test/java/grid/dynamics/scratch.json"), EmployeeContainer.class);
        List<Employee> eList = jsonObj.getEmployees().getEmployee();
        // Print employee details directly without getters/setters
        for (Employee emply : eList) {
            emply.printEmployeeDetails();  // Directly call the method to print private fields
        }
        EmployeeContainer employeesCt = obj.readValue(Outerjson, EmployeeContainer.class);
        System.out.println(employeesCt);

        Employees employees = obj.readValue(empl0yee, Employees.class);
        System.out.println(employees);

        Employee employee = obj.readValue(emp, Employee.class);
        System.out.println(employee);

    }
}
