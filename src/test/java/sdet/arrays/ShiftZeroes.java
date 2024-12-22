package sdet.arrays;

import java.util.Arrays;

public class ShiftZeroes {
    public static void shiftZeroesToRear(int[] arr, int index, int nonZeroIndex) {
        // Base case: If we've processed the entire array
        if (index == arr.length) {
            while (nonZeroIndex < arr.length) {
                arr[nonZeroIndex++] = 0;
            }
            return;
        }

        // If current element is non-zero, move it to the nonZeroIndex
        if (arr[index] != 0) {
            arr[nonZeroIndex] = arr[index];
            nonZeroIndex++;
        }

        // Recursive call to the next index
        shiftZeroesToRear(arr, index + 1, nonZeroIndex);
    }

    public static void shiftZeroesToFront(int[] arr, int index, int zeroIndex) {
        // Base case: If we've processed the entire array
        if (index < 0) {
            while (zeroIndex >= 0) {
                arr[zeroIndex--] = 0;
            }
            return;
        }

        // If current element is non-zero, move it to the zeroIndex
        if (arr[index] != 0) {
            arr[zeroIndex] = arr[index];
            zeroIndex--;
        }

        // Recursive call to the previous index
        shiftZeroesToFront(arr, index - 1, zeroIndex);
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12, 0, 4};
        shiftZeroesToRear(arr, 0, 0);
        System.out.println(Arrays.toString(arr));
        for (int num : arr) {
            System.out.print(num + " ");
        }
        // Output: 1 3 12 4 0 0 0
        System.out.println("--------");
        shiftZeroesToFront(arr, arr.length - 1, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        // Output: 0 0 0 1 3 12 4
    }
}
