package sdet.practice;

public class ReverseInSubsets {

    // Method to reverse in subsets of size N
    public static void reverseInSubsets(int[] arr, int N) {
        for (int i = 0; i < arr.length; i += N) {
            int left = i;
            // Calculate the right index for the current subset
            int right = Math.min(i + N - 1, arr.length - 1);

            // Reverse the current subset
            while (left < right) {
                // Swap the elements
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int N = 3;

        System.out.println("Original Array:");
        printArray(arr);

        reverseInSubsets(arr, N);

        System.out.println("Array after reversing in subsets of size " + N + ":");
        printArray(arr);
    }
}

