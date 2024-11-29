package sdet.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentComparator {
    static class Student {
        String name;
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Overridden toString() method for custom output
        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + '}';
        }
    }

    // Comparator to sort by name
    static class SortByName implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.name.compareTo(s2.name);  // Sort by name
        }
    }

    // Comparator to sort by age
    static class SortByAge implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Integer.compare(s1.age, s2.age);  // Sort by age
        }
    }

    public static void main(String[] args) {

        // Usage
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 23));
        students.add(new Student("Bob", 20));
        students.add(new Student("Charlie", 25));

        Collections.sort(students, new SortByName());  // Sort by name
        System.out.println("Sorted by name:");
        System.out.println("Sorted by name:");
        for (Student student : students) {
            System.out.println(student); // This will call the overridden toString()
        }
        Collections.sort(students, new SortByAge());   // Sort by age
        System.out.println("Sorted by age:");
        for (Student student : students) {
            System.out.println(student); // This will call the overridden toString()
        }
    }
}
