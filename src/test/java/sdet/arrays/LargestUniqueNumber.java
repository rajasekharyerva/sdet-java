package sdet.arrays;

import java.util.*;

public class LargestUniqueNumber {
    public static int findLargestUnique(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // Return -1 if the array is empty
        }

        // Step 1: Count frequencies using a HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find the largest number with frequency 1
        int largestUnique = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1 && entry.getKey() > largestUnique) {
                largestUnique = entry.getKey();
            }
        }

        // If no unique number is found, return -1
        return largestUnique == Integer.MIN_VALUE ? -1 : largestUnique;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 3, 4, 8};
        int result = findLargestUnique(arr);
        System.out.println(result); // Output: 8
    }
}

