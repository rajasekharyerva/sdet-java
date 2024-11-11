package sdet.strings;

import java.util.HashMap;
import java.util.Map;

public class MaxMinOccurrences {
    public static void main(String[] args) {
        String input = "Teeeessst Autoooooomationn";

        // Get and print max and min occurrences
        getMaxMinOccurrences(input);
    }

    public static void getMaxMinOccurrences(String input) {
        // Step 1: Count occurrences of each character using a map
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char ch : input.toCharArray()) {
            if (ch != ' ') {  // Ignore spaces
                charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
            }
        }

        // Step 2: Find the character with max and min occurrences
        char maxChar = 0;
        char minChar = 0;
        int maxCount = Integer.MIN_VALUE;
        int minCount = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount) {
                maxCount = count;
                maxChar = ch;
            }

            if (count < minCount) {
                minCount = count;
                minChar = ch;
            }
        }

        // Step 3: Print the results
        System.out.println("Character with max occurrence: " + maxChar + "-" + maxCount);
        System.out.println("Character with min occurrence: " + minChar + "-" + minCount);
    }
}

