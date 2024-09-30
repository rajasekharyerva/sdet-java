package selenium.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public static String generateRandomDOB() {
        // Define the age range
        int minAge = 18; // Minimum age
        int maxAge = 60; // Maximum age

        // Get the current year
        int currentYear = LocalDate.now().getYear();

        // Calculate the year of birth based on age
        int yearOfBirth = ThreadLocalRandom.current().nextInt(currentYear - maxAge, currentYear - minAge + 1);

        // Generate a random month and day
        int month = ThreadLocalRandom.current().nextInt(1, 13);
        int day = ThreadLocalRandom.current().nextInt(1, 29); // Using 1-28 to simplify (February can have 29 in leap years)

        // Create the date
        LocalDate dob = LocalDate.of(yearOfBirth, month, day);

        // Format the date to "yyyy-MM-dd"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dob.format(formatter);
    }
    public static String selectRandomGender() {
        // Array of genders to choose from
        String[] genders = {"male", "female", "other"};

        // Use Random class to select a gender
        Random random = new Random();
        return genders[random.nextInt(genders.length)];
    }
}
