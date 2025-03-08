package collections.sorting;

public class BinarySearchExample {

    // Function to perform binary search
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // To prevent overflow

            // Check if the target is at mid
            if (arr[mid] == target) {
                return mid; // Return the index of the target
            }

            // If target is smaller, ignore the right half
            if (arr[mid] > target) {
                high = mid - 1;
            } else {
                // If target is larger, ignore the left half
                low = mid + 1;
            }
        }

        // Target not found
        return -1;
    }

    // Main method to test binary search
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40}; // Array must be sorted
        int target = 10;

        System.out.println("Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Perform binary search
        int result = binarySearch(arr, target);

        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}

