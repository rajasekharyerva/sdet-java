package arrays;

import java.util.Arrays;

public class SubArrayWithGivenSum {

    // Method to find a subarray with the given sum
    public static void findSubarrayWithSum(int[] numbers, int expectedSum) {
        int n = numbers.length;
        int currentSum = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            // Add the current element to the current sum
            currentSum += numbers[end];

            // While current sum exceeds expected sum, shrink the window from the start
            while (currentSum > expectedSum && start <= end) {
                currentSum -= numbers[start];
                start++;
            }

            // Check if current sum equals expected sum
            if (currentSum == expectedSum) {
                System.out.println("Subarray with the given sum found: " +
                        Arrays.toString(Arrays.copyOfRange(numbers, start, end + 1)));
                return; // Exit after finding the first valid subarray
            }
        }

        System.out.println("No subarray with the given sum found.");
    }

    public static void main(String[] args) {
        int[] numbers = {1, 4, 20, 3, 10, 5};
        int expectedSum = 33;

        findSubarrayWithSum(numbers, expectedSum);
    }
}


