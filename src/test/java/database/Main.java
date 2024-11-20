package database;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Instantiate the DAO
        UserDAO userDAO = new UserDAO();

        // Get all users
        List<User> users = userDAO.getAllUsers();

        // Print all users
        for (User user : users) {
            System.out.println(user);
        }

        // Get a user by ID
        User userById = userDAO.getUserById(1);
        if (userById != null) {
            System.out.println("User with ID 1: " + userById);
        } else {
            System.out.println("No user found with ID 1");
        }
    }
}

