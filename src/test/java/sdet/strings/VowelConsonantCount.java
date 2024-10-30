package sdet.strings;

import java.util.Scanner;

public class VowelConsonantCount {
    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Input string from the user
        System.out.println("Enter a string: ");
        String input = scanner.nextLine().toLowerCase(); // Convert to lowercase for simplicity

        // Variables to store counts of vowels and consonants
        int vowels = 0, consonants = 0;

        // Loop through each character in the string
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // Check if the character is a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            }
            // Check if the character is a consonant (a letter that is not a vowel)
            else if (ch >= 'a' && ch <= 'z') {
                consonants++;
            }
        }

        // Print the result
        System.out.println("Number of Vowels: " + vowels);
        System.out.println("Number of Consonants: " + consonants);

        // Close the scanner
        scanner.close();
    }
}
