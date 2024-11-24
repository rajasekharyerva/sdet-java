package sdet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UsernameValidator {
    // Set to store already used usernames
    private static Set<String> usedUsernames = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get username input
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        // Check if the username is valid
        if (isValidUsername(username)) {
            if (usedUsernames.contains(username)) {
                System.out.println("Invalid: Username is already taken.");
            } else {
                usedUsernames.add(username);
                System.out.println("Valid: Username accepted.");
            }
        } else {
            System.out.println("Invalid: Username contains special characters or spaces.");
        }

        scanner.close();
    }

    // Validate the username
    public static boolean isValidUsername(String username) {
        // Check for alphanumeric and no spaces/special characters
        return username.matches("^[a-zA-Z0-9]+$");
    }
}

