package collections.arrays;

public class SmallestElementInArray {
    public static void main(String[] args) {
        // Example array
        int[] array = {5, 8, 2, 1, 9, 3};

        // Assume the first element is the smallest
        int smallest = array[0];

        // Iterate through the array to find the smallest element
        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }

        // Print the smallest element
        System.out.println("The smallest element in the array is: " + smallest);
    }
}

