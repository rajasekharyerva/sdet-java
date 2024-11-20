package sdet.numbers;

import java.util.ArrayList;
import java.util.List;

public class FindNDigitsWithSum {
    public static void main(String[] args) {
        int sum = 6;
        int n = 2;
        List<List<Integer>> result = findCombinations(sum, n);
        System.out.println(result);
    }

    // Function to find combinations
    public static List<List<Integer>> findCombinations(int sum, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        findCombinationsHelper(sum, n, 1, current, result);
        return result;
    }

    // Recursive backtracking helper
    private static void findCombinationsHelper(int sum, int n, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == n) {
            if (sum == 0) {
                result.add(new ArrayList<>(current)); // Add a valid combination
            }
            return;
        }

        for (int i = start; i <= sum; i++) {
            current.add(i); // Choose the number
            findCombinationsHelper(sum - i, n, i, current, result); // Recur with reduced sum
            current.remove(current.size() - 1); // Backtrack
        }
    }
}

