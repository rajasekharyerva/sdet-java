package sdet.arrays;

public class OddEvenArray {
    public static void main(String[] args) {
        // Example array
        int[] array = {12, 3, 5, 8, 7, 10, 15, 20};

        // Print even numbers
        System.out.println("Even numbers:");
        for (int num : array) {
            if (num % 2 == 0) { // Check if the number is even
                System.out.print(num + " ");
            }
        }

        // Print odd numbers
        System.out.println("\nOdd numbers:");
        for (int num : array) {
            if (num % 2 != 0) { // Check if the number is odd
                System.out.print(num + " ");
            }
        }
    }
}
