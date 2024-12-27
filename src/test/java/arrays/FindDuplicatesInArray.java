package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindDuplicatesInArray {
    public static void main(String[] args) {
        String[] arr = {"java", "python", "C", "C++", "java", "python"};


        findDuplicates(arr);
        findDuplicates2(arr);
        findDuplicates3(arr);
    }

    private static void findDuplicates3(String[] arr) {
        // Use a HashSet to track seen elements
        HashSet<String> seen = new HashSet<>();
        boolean duplicatesFound = false;

        // Iterate through the array to find duplicates
        for (int i = 0; i < arr.length; i++) {
            if (!seen.add(arr[i])) {
                // If add() returns false, the element is a duplicate
                System.out.println("Duplicate element: " + arr[i]);
                duplicatesFound = true;
            }
        }

        // If no duplicates were found
        if (!duplicatesFound) {
            System.out.println("No duplicate elements found.");
        }
    }

    private static void findDuplicates2(String[] arr) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String str : arr) {
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + "->" + entry.getValue());
            }
        }
    }

    private static void findDuplicates(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    System.out.println("Found duplicate element " + arr[i]);
                }
                //System.out.println("-");
            }
        }
    }
}
