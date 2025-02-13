package spring.boot;

public class User {

    private Long id;
    private String name;

    // Default constructor
    public User() {
    }

    // Constructor with fields
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "'}";
    }
}