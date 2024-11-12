package sdet.arrays;

import java.util.Arrays;

public class IncrementArray {
    public static void main(String[] args) {
        int[] arr = {8, 9, 9}; // Input array
        arr = incrementNumber(arr); // Increment the number and get the updated array
        System.out.println("Output: " + Arrays.toString(arr)); // Print the updated array
    }

    public static int[] incrementNumber(int[] arr) {
        int n = arr.length;

        // Traverse the array from the rightmost digit
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < 9) {
                arr[i]++; // Increment the current digit
                // Set all subsequent digits to 0
                //Arrays.fill(arr, i + 1, n, 0);
                return arr;
            } else {
                arr[i] = 0; // Set current digit to 0 if it was 9
            }
        }
        // If all digits were 9, we need a new array
        int[] newArr = new int[n + 1];
        newArr[0] = 1; // Set the first digit to 1, rest are already 0
        return newArr; // Return the new array with one additional digit

    }
}

