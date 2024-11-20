package sdet.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeExample {
    public static void main(String[] args) {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define the format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Format the date and time
        String formattedDateTime = currentDateTime.format(formatter);

        // Print the formatted date and time
        System.out.println("Current Date and Time: " + formattedDateTime);
    }
}

