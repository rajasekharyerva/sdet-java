package sdet.strings;

import java.util.*;

public class StringPermutations {

    // Function to generate all permutations of the string
    public static void permute(String str, int l, int r, List<String> result) {
        if (l == r) {
            result.add(str); // Add permutation to result when all characters are fixed
        } else {
            for (int i = l; i <= r; i++) {
                // Swap characters at positions l and i
                str = swap(str, l, i);

                // Recursively permute the remaining string
                permute(str, l + 1, r, result);

                // Backtrack: Swap back the characters to the original position
                str = swap(str, l, i);
            }
        }
    }

    // Helper function to swap characters in the string
    private static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }

    public static void main(String[] args) {
        String str = "ABC"; // Sample string
        List<String> result = new ArrayList<>();

        permute(str, 0, str.length() - 1, result);

        // Print all permutations
        System.out.println("All Permutations:");
        for (String perm : result) {
            System.out.println(perm);
        }
    }
}

