package sdet.numbers;

import java.util.HashSet;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 3, 3, 3, 3};  // Example array

        // Step 1: Calculate Total Sum
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // Step 2: Calculate Unique Sum using a Set
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        int uniqueSum = 0;
        for (int num : arr) {
            if (!uniqueNumbers.contains(num)) {
                uniqueNumbers.add(num);
                uniqueSum += num;
            }
        }

        // Step 3: Apply the formula to find the duplicate number
        int duplicateNumber = (totalSum - uniqueSum) / 4;

        // Step 4: Output the result
        System.out.println("The duplicate number is: " + duplicateNumber);
    }
}

