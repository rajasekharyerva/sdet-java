package sdet.collections;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private Date createdAt;

    public Student(int id, String name, String createdAt) {
        this.id = id;
        this.name = name;
        this.setCreatedAt(createdAt);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(createdAt);
    }

    public void setCreatedAt(String createdAt) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.createdAt = sdf.parse(createdAt);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {

        return this.id + ", " + this.name + ", " + this.getCreatedAt();
    }

    public static Comparator<Student> DATE_COMPARATOR = (o1, o2) -> o1.getCreatedAt().compareTo(o2.getCreatedAt());


    @Override
    public int compareTo(Student o) {
        return this.createdAt.compareTo(o.createdAt);
    }
}
