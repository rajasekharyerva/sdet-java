package sdet;

import java.util.ArrayList;

public class ReverseStringWithSpaces {
    public static String reverseStringWithSpaces(String str) {
        // Create a list to store non-space characters
        ArrayList<Character> chars = new ArrayList<>();

        // Extract non-space characters
        for (char c : str.toCharArray()) {
            if (c != ' ') {
                chars.add(c);
            }
        }

        // Reverse the list of characters
        StringBuilder reversedChars = new StringBuilder();
        for (int i = chars.size() - 1; i >= 0; i--) {
            reversedChars.append(chars.get(i));
        }

        // Rebuild the result string
        StringBuilder result = new StringBuilder();
        int index = 0; // Pointer for reversed characters
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                result.append(' '); // Maintain space
            } else {
                result.append(reversedChars.charAt(index)); // Add reversed character
                index++; // Move to the next reversed character
            }
        }

        return result.toString(); // Convert StringBuilder to String
    }

    public static void main(String[] args) {
        String inputString = "I am a boy";
        String outputString = reverseStringWithSpaces(inputString);
        System.out.println("Output: " + outputString); // Output: y ob a maI
    }
}
