package sdet.collections;

import java.util.List;

public class LargestNumberFinderList {

    // Function to find the largest number in the list
    public static int findLargest(List<Integer> numbers) {
        // Check if the list is empty
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("The list is empty.");
        }

        // Initialize the largest number to the first element of the list
        int largest = numbers.get(0);

        // Iterate through the list to find the largest number
        for (int num : numbers) {
            if (num > largest) {
                largest = num;
            }
        }

        return largest;
    }

    public static void main(String[] args) {
        // Sample list of numbers
        List<Integer> numbers = List.of(10, 45, 23, 78, 99, 12, 34);

        // Find the largest number
        int largest = findLargest(numbers);

        // Print the largest number
        System.out.println("The largest number in the list is: " + largest);
    }
}

