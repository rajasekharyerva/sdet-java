package sdet;

import java.util.ArrayList;
import java.util.List;

public class EmployeeProgram {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        // Creating Employee objects
        employees.add(new Employee("Alice", 30, 50000));
        employees.add(new Employee("Bob", 28, 60000));
        employees.add(new Employee("Charlie", 35, 55000));
        employees.add(new Employee("Diana", 40, 70000));

        // Calculating the average salary
        int totalSalary = 0;
        for (Employee emp : employees) {
            totalSalary += emp.getSalary();
        }
        int averageSalary = totalSalary / employees.size();

        System.out.println("Average Salary: " + averageSalary);
    }
}
