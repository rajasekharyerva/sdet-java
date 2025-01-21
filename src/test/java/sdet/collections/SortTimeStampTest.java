package sdet.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTimeStampTest {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(4, "Suresh", "2018-03-23"));
        studentList.add(new Student(14, "Mani", "2018-03-13"));
        studentList.add(new Student(28, "Suresh", "2018-02-23"));
        studentList.add(new Student(24, "Siva Shankar", "2017-03-23"));

        //Collections.sort(studentList, Student.DATE_COMPARATOR);
        Collections.sort(studentList);
        studentList.stream().forEach(System.out::println);
    }
}
