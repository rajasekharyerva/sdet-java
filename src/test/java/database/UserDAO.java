package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // Method to get all users
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        Connection connection = DBHelper.getInstance().getConnection();

        String query = "SELECT id, name, email FROM users";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                // Create User object and add it to the list
                User user = new User(id, name, email);
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    // Method to get a user by ID
    public User getUserById(int userId) {
        User user = null;
        Connection connection = DBHelper.getInstance().getConnection();

        String query = "SELECT id, name, email FROM users WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    user = new User(id, name, email);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}

