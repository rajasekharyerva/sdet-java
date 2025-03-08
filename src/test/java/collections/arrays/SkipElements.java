package collections.arrays;

public class SkipElements {
    public static int calculateSum(int[] arr) {
        int sum = 0;
        boolean skipUntil7 = false; // Flag to indicate if we need to skip elements

        for (int i = 0; i < arr.length; i++) {

            // When 3 is found, start skipping
            if (arr[i] == 3) {
                skipUntil7 = true;
            }

            // Add elements before 3
            if (!skipUntil7) {
                sum += arr[i]; // Sum elements until we encounter 3
            }


            // When 7 is found, stop skipping and start summing
            if (arr[i] == 7) {
                sum += arr[i]; // Add 7 to sum
                skipUntil7 = false; // Stop skipping after 7
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7, 8, 9};
        int result = calculateSum(arr);
        System.out.println("Sum of elements after skipping 3 and starting at 7: " + result);
    }
}
