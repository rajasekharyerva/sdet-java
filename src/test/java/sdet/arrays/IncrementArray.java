package sdet.arrays;

import java.util.Arrays;

public class IncrementArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 9}; // Input array
        incrementNumber(arr); // Increment the number represented by the array
        System.out.println("Output: " + Arrays.toString(arr)); // Print the updated array
    }

    public static void incrementNumber(int[] arr) {
        int n = arr.length;

        // Traverse the array from the rightmost digit
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < 9) {
                arr[i]++; // Increment the current digit
                // Set all subsequent digits to 0
                Arrays.fill(arr, i + 1, n, 0);
                return; // Exit after the increment operation
            } else {
                arr[i] = 0; // Set current digit to 0 if it was 9
            }
        }

        // If all digits were 9, the array will have all 0s now.
        // In this case, we need to extend the array by 1 digit and set the first digit to 1.
        int[] newArr = new int[n + 1];
        newArr[0] = 1; // Set the first digit to 1
        System.arraycopy(arr, 0, newArr, 1, n); // Copy the original array into the new array
        System.arraycopy(newArr, 0, arr, 0, newArr.length); // Replace original array with new array
    }
}

