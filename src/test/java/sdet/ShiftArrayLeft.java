package sdet;

public class ShiftArrayLeft {

    // Method to shift the array to the left by k positions
    public static void shiftLeft(int[] arr, int k) {
        int n = arr.length;

        // Ensure k is within the bounds of the array length
        k = k % n;

        // Create a new array to store the result
        int[] result = new int[n];

        // Fill the new array with shifted values
        for (int i = 0; i < n; i++) {
            result[i] = arr[(i + k) % n];
        }

        // Copy the result back to the original array
        System.arraycopy(result, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8};
        int k = 1;

        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        shiftLeft(arr, k);

        System.out.println("\nArray after shifting left by " + k + " positions:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

