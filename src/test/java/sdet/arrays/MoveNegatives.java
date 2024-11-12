package sdet.arrays;

public class MoveNegatives {

    // Method to move all negative numbers to the start of the array
    public static void moveNegativesToFront(int[] arr) {
        int index = 0; // Index to place the next negative number

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // If the element is negative, swap it with the element at the 'index' position
            if (arr[i] < 0) {
                if (i != index) {
                    int temp = arr[i];
                    arr[i] = arr[index];
                    arr[index] = temp;
                }
                index++; // Move index forward for the next negative number
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -4, 5, -8, 7, -6, 9};

        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        moveNegativesToFront(arr);

        System.out.println("\nArray after moving negatives to the front:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

