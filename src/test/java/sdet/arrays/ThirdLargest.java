package sdet.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThirdLargest {
    public static int findThirdLargest(int[] arr) {
        // Remove duplicates
        Set<Integer> distinctNumbers = new HashSet<>();
        for (int num : arr) {
            distinctNumbers.add(num);
        }

        // Convert set to array and sort in descending order
        Integer[] distinctArray = distinctNumbers.toArray(new Integer[0]);
        Arrays.sort(distinctArray, (a, b) -> b - a);

        // Check for third largest
        if (distinctArray.length >= 3) {
            return distinctArray[2]; // Third largest
        } else {
            return distinctArray[0]; // Largest number
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 5, 3, 6};
        System.out.println(findThirdLargest(arr)); // Output: 4
    }
}

