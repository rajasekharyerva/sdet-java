package sdet.collections;

import java.util.HashMap;
import java.util.Map;

public class ElementFrequency {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4}; // Sample input array
        findFrequency(arr);
    }

    public static void findFrequency(int[] arr) {
        // Create a HashMap to store element frequencies
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Traverse the array
        for (int num : arr) {
            // If the element is already in the map, increment its count
            // Otherwise, put it in the map with a count of 1
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Display the frequencies
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("Element " + entry.getKey() + " occurs " + entry.getValue() + " times.");
        }
    }
}

