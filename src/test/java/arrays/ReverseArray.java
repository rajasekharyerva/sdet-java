package arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // Sample input array
        printReverse(arr);
    }

    public static void printReverse(int[] arr) {
        System.out.println("Array elements in reverse order:");
        // Loop through the array in reverse order
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}

