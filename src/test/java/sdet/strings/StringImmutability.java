package sdet.strings;

public class StringImmutability {
    public static void main(String[] args) {

        // Create a String object
        String str1 = "Hello";

        // Attempt to change the string by modifying it
        str1.concat(" World");

        // Print original string to show that it has not been modified
        System.out.println("Original String: " + str1);  // Output: Hello

        // Assign the result of concatenation to a new variable
        String str2 = str1.concat(" World");

        // Print the new string which contains the modified value
        System.out.println("Modified String: " + str2);  // Output: Hello World

        // Verify that the original string remains unchanged
        System.out.println("Original String after modification attempt: " + str1);  // Output: Hello
    }
}

