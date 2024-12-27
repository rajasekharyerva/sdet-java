import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        // Input set
        char[] set = {'a', 'b', 'c'};

        // Generate subsets
        List<List<Character>> subsets = findSubsets(set);

        // Print subsets
        System.out.println("Subsets:");
        for (List<Character> subset : subsets) {
            System.out.println(subset);
        }
    }

    public static List<List<Character>> findSubsets(char[] set) {
        List<List<Character>> result = new ArrayList<>();
        int n = set.length;

        // There are 2^n subsets
        int totalSubsets = 1 << n; // 2^n

        for (int i = 0; i < totalSubsets; i++) {
            List<Character> subset = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                // Check if jth bit in i is set
                if ((i & (1 << j)) != 0) {
                    subset.add(set[j]);
                }
            }

            result.add(subset);
        }

        return result;
    }
}
