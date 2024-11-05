package sdet.strings;

import java.util.HashMap;
import java.util.Map;

public class LetterFrequency {

    public static void countLetterOccurrences(String input) {
        // Convert the input string to lowercase for case-insensitive counting
        input = input.toLowerCase();

        // Create a map to store character frequencies
        Map<Character, Integer> letterCountMap = new HashMap<>();

        // Iterate over the characters in the input string
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                // If the letter is already in the map, increment its count
                letterCountMap.put(ch, letterCountMap.getOrDefault(ch, 0) + 1);
            }
        }

        // Print the letter frequencies
        for (Map.Entry<Character, Integer> entry : letterCountMap.entrySet()) {
            System.out.println("Letter: " + entry.getKey() + ", Count: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String input = "Hello World";
        countLetterOccurrences(input);
    }


}

