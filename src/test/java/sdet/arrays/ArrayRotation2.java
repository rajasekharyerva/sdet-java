package sdet.arrays;

import java.util.Arrays;

public class ArrayRotation2 {
    public static void rotateArray(Object[] arr, int k) {
        int n = arr.length;
        char[] result = new char[n];
        k = k % n; // Handle cases where k > n

        // Place elements in their new positions
        for (int i = 0; i < n; i++) {
            //result[(i + k) % n] = arr[i];
            result[(i - k + n) % n] = (char) arr[i];
        }

        String str = new String(result);

        System.out.println(Arrays.toString(result));

        // Copy the result back to the original array
        System.arraycopy(result, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        Character[] charArray = {'H', 'e', 'l', 'l', 'o'};
        int k = 2; // Number of rotations

        rotateArray(charArray, k);
        System.out.print("Rotated Character Array: ");
        for (char ch : charArray) {
            System.out.print(ch + " ");
        }
    }
}

