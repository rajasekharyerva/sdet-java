package sdet.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentComparable {
    static class Student implements Comparable<Student> {
        String name;
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Student other) {
            return Integer.compare(this.age, other.age);  // Sort by age
        }

        // Overridden toString() method for custom output
        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + '}';
        }
    }

    public static void main(String[] args) {

// Usage
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 23));
        students.add(new Student("Bob", 20));
        students.add(new Student("Charlie", 25));

        Collections.sort(students); // Sorts students based on age
        System.out.println(students);
    }
}

