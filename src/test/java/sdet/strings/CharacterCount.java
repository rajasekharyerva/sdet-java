package sdet.strings;

import java.util.HashMap;
import java.util.Map;

public class CharacterCount {
    public static void main(String[] args) {
        String input = "programming"; // Example input string

        // Call the method to count characters
        countCharacterOccurrences(input);
    }

    // Method to count the occurrences of each character
    public static void countCharacterOccurrences(String str) {
        // Create a map to store character counts
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Convert string to char array and iterate
        for (char c : str.toCharArray()) {
            // If the character is already in the map, increment its count
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Print the character counts
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

