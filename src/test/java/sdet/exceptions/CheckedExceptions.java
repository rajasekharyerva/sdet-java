package sdet.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckedExceptions {
    //IOException, SQLException, ClassNotFoundException
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO users VALUES(1, 'John Doe')"); // SQL query execution
        } catch (SQLException e) {
            System.out.println("SQLException occurred: " + e.getMessage());
        }


        try(FileReader fr = new FileReader("nonexistentfile.txt")) {
            // FileNotFoundException
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (FileNotFoundException e) {
            // Specifically handling FileNotFoundException
            System.out.println("FileNotFoundException: The file was not found.");
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }

}
