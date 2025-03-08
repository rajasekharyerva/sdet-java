package arrays;

public class ShiftArrayRight {

    // Method to shift the array to the right by k positions
    public static void shiftRight(int[] arr, int k) {
        int n = arr.length;

        // Ensure k is within the bounds of the array length
        k = k % n;

        // Create a interview19.txt array to store the result
        int[] result = new int[n];

        // Fill the interview19.txt array with shifted values
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = arr[i];
        }

        // Copy the result back to the original array
        System.arraycopy(result, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;

        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        shiftRight(arr, k);

        System.out.println("\nArray after shifting right by " + k + " positions:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

