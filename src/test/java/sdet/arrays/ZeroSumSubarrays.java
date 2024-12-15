package sdet.arrays;

import java.util.*;

public class ZeroSumSubarrays {

    // Method to find subarrays with zero sum
    public static List<List<Integer>> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        // Initialize sumMap with sum 0 at index -1 (this helps to handle subarrays starting from index 0)
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        int sum = 0;

        // Traverse the array and compute prefix sum
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If sum already exists in the map, it means a subarray with sum 0 is found
            if (sumMap.containsKey(sum)) {
                // Find all previous indices with the same sum
                for (Integer startIdx : sumMap.get(sum)) {
                    List<Integer> subarray = new ArrayList<>();
                    for (int j = startIdx + 1; j <= i; j++) {
                        subarray.add(arr[j]);
                    }
                    result.add(subarray); // Add the subarray to the result
                }
            }

            // Add the current index to the list of indices for the current sum
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        return result;
    }

    // Main method for testing the function
    public static void main(String[] args) {
        int[] arr = {4, -3, 2, 1, 6, -4, -2, 3, 5};
        List<List<Integer>> subarrays = findZeroSumSubarrays(arr);
        System.out.println(subarrays);
    }
}
