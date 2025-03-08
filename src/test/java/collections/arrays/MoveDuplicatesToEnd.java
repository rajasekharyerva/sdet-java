package collections.arrays;

import java.util.ArrayList;
import java.util.HashSet;

public class MoveDuplicatesToEnd {

    // Method to move duplicates to the end of the array
    public static void moveDuplicatesToEnd(int[] arr) {
        HashSet<Integer> seen = new HashSet<>(); // To track unique elements
        ArrayList<Integer> uniqueList = new ArrayList<>();
        ArrayList<Integer> duplicateList = new ArrayList<>();

        // Pass 1: Separate unique and duplicate elements
        for (int num : arr) {
            if (!seen.contains(num)) {
                seen.add(num); // Mark as seen
                uniqueList.add(num); // Add to unique list
            } else {
                duplicateList.add(num); // Add to duplicate list
            }
        }

        // Combine unique and duplicate lists back into the original array
        int index = 0;
        for (int num : uniqueList) {
            arr[index++] = num; // Fill unique elements
        }
        for (int num : duplicateList) {
            arr[index++] = num; // Fill duplicate elements
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 3, 2, 3, 2, 5};
        moveDuplicatesToEnd(arr);

        // Print the modified array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
