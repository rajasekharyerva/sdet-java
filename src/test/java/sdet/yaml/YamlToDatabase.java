package sdet.yaml;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

public class YamlToDatabase {

    public static void main(String[] args) {
        // Step 1: Load YAML file
        Yaml yaml = new Yaml();
        try (InputStream inputStream = YamlToDatabase.class.getClassLoader().getResourceAsStream("data.yaml")) {
            if (inputStream == null) {
                throw new RuntimeException("data.yaml not found in resources!");
            }

            Map<String, Object> data = yaml.load(inputStream);
            if (data == null || !data.containsKey("users")) {
                throw new RuntimeException("Invalid YAML structure: 'users' key not found.");
            }


            List<Map<String, Object>> users = (List<Map<String, Object>>) data.get("users");
            // Step 2: Store in Database
            storeInDatabase(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void storeInDatabase(List<Map<String, Object>> users) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/mydb";
        String username = "user";
        String password = "user_password";

        String insertQuery = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            for (Map<String, Object> user : users) {
                preparedStatement.setInt(1, (Integer) user.get("id"));
                preparedStatement.setString(2, (String) user.get("name"));
                preparedStatement.setString(3, (String) user.get("email"));
                preparedStatement.executeUpdate();
            }

            System.out.println("Data inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

