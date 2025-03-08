package arrays;

import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {

    // Method to find the intersection of two collections.arrays
    public static Set<Integer> findIntersection(int[] arr1, int[] arr2) {
        // Create a HashSet to store elements of the first array
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        // Add elements of arr1 to the set
        for (int num : arr1) {
            set.add(num);
        }

        // Check if elements of arr2 are present in the set (intersection)
        for (int num : arr2) {
            if (set.contains(num)) {
                intersection.add(num);
            }
        }

        return intersection; // Return the intersection set
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {2, 2};

        // Find and print the intersection of the two collections.arrays
        Set<Integer> result = findIntersection(arr1, arr2);
        System.out.println("Intersection: " + result);
    }
}

