package sdet.java.java8.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectToMapExample {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "Alice", 3000),
                new Employee(2, "Bob", 4000),
                new Employee(3, "Charlie", 3500)
        );

        // Convert list of employees to a Map (id -> name)
        Map<Integer, String> employeeMap = employees.stream()
                .collect(Collectors.toMap(Employee::getId, Employee::getName));
        System.out.println("Employee Map: " + employeeMap);
    }
}

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
}

