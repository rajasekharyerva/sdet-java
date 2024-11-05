package sdet.numbers;

import java.util.HashSet;

public class PairSum {
    public static void findPairs(int[] arr, int sum) {
        // Create a HashSet to store the elements we've seen so far
        HashSet<Integer> seen = new HashSet<>();

        System.out.println("Pairs that add up to " + sum + ":");

        // Loop through the array
        for (int num : arr) {
            // Calculate the required number to form a pair with the current number
            int complement = sum - num;

            // If the complement exists in the set, we have found a pair
            if (seen.contains(complement)) {
                System.out.println("{" + complement + ", " + num + "}");
            }
            // Add the current number to the set
            seen.add(num);
        }
    }

    public static void main(String[] args) {
        // Example array and sum
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 10;

        // Call the function to find pairs
        findPairs(arr, sum);
    }
}
