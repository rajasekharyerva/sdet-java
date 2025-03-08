package collections.arrays;

public class ArraySortedCheck {

    // Method to check if array is sorted in ascending order
    public static boolean isSortedAscending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Method to check if array is sorted in descending order
    public static boolean isSortedDescending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Method to check if array is sorted (either ascending or descending)
    public static boolean isSorted(int[] arr) {
        return isSortedAscending(arr) || isSortedDescending(arr);
    }

    public static void main(String[] args) {
        int[] ascendingArray = {1, 2, 3, 4, 5};
        int[] descendingArray = {5, 4, 3, 2, 1};
        int[] unsortedArray = {3, 1, 4, 2, 5};

        System.out.println("Is ascendingArray sorted? " + isSorted(ascendingArray));    // true
        System.out.println("Is descendingArray sorted? " + isSorted(descendingArray));  // true
        System.out.println("Is unsortedArray sorted? " + isSorted(unsortedArray));      // false
    }
}

