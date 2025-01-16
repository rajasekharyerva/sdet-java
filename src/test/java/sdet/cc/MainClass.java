package sdet.cc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(7, "Raja"));
        employees.add(new Employee(5, "Ashok"));
        employees.add(new Employee(2, "Niranjan"));
        Collections.sort(employees);

        System.out.println(employees.toString());

        employees.sort((e1, e2) -> e1.name.compareTo(e2.name));
        System.out.println("Sorted by Name: " + employees);

        // Sort by ID in descending order
        employees.sort((e1, e2) -> e2.id - e1.id);
        System.out.println("Sorted by ID (Descending): " + employees);

        //employees.sort();

    }
}
