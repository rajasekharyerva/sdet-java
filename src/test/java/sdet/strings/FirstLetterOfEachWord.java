package sdet.strings;

public class FirstLetterOfEachWord {
    public static void main(String[] args) {
        String input = "This is a sample sentence";

        // Call the method to print the first letter of each word
        printFirstLetterOfEachWord(input);
    }

    // Method to print first letter of each word in a string
    public static void printFirstLetterOfEachWord(String input) {
        // Split the input string into words
        String[] words = input.split("\\s+");  // Splits by whitespace

        // Loop through each word and print the first letter
        for (String word : words) {
            System.out.print(word.charAt(0) + " ");  // Print first character of each word
        }
    }
}

