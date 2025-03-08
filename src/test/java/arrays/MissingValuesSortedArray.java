package arrays;

import java.util.ArrayList;
import java.util.List;

public class MissingValuesSortedArray {
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 4, 6, 7, 7, 10};
        for (int i = 0; i < sortedArray.length - 1; i++) {
            int diff = sortedArray[i + 1] - sortedArray[i];
            int temp = sortedArray[i];
            while (diff > 1) {
                temp = temp + 1;
                System.out.println(temp);
                diff--;
            }

        }
    }

    public static class MissingValues {
        public static void main(String[] args) {
            int[] arr = {1, 2, 4, 7, 8, 10};
            List<Integer> missingValues = findMissingValues(arr);

            System.out.println("Missing values: " + missingValues);
        }

        public static List<Integer> findMissingValues(int[] arr) {
            List<Integer> missing = new ArrayList<>();

            for (int i = 0; i < arr.length - 1; i++) {
                int current = arr[i];
                int next = arr[i + 1];

                // Check if there is a gap between the current and next element
                for (int j = current + 1; j < next; j++) {
                    missing.add(j);
                }
            }

            return missing;
        }
    }

}
