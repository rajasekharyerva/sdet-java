package sdet.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinDeletionsUniqueFrequencies {
    public static int minDeletions(String s) {
        // Step 1: Count character frequencies
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step faq2: Use a set to track used frequencies
        Set<Integer> usedFrequencies = new HashSet<>();
        int deletions = 0;

        for (int freq : frequencyMap.values()) {
            // Adjust frequency until it's unique
            while (freq > 0 && usedFrequencies.contains(freq)) {
                freq--;
                deletions++;
            }
            usedFrequencies.add(freq);
        }

        return deletions;
    }

    public static void main(String[] args) {
        String input = "aabbcc";
        System.out.println("Minimum deletions: " + minDeletions(input));

        input = "aaabbbcc";
        System.out.println("Minimum deletions: " + minDeletions(input));

        input = "abcde";
        System.out.println("Minimum deletions: " + minDeletions(input));
    }
}
