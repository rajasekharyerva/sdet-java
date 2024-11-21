package sdet.arrays;

public class SumArray {
    public static void main(String[] args) {
        // Example array
        int[] array = {5, 8, 2, 1, 9, 3};

        // Initialize a variable to store the sum
        int sum = 0;

        // Iterate through the array and add each element to the sum
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        // Print the sum of all elements
        System.out.println("The sum of all elements in the array is: " + sum);
    }
}

