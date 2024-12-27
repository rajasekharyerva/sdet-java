package arrays;

public class ArrayRotation {
    // Method to rotate the array by k positions to the right
    public static void rotateArray(Object[] arr, int k) {
        int n = arr.length;
        k = k % n;  // Handle cases where k > n

        // Step 1: Reverse the entire array
        reverseArray(arr, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverseArray(arr, 0, k - 1);

        // Step 3: Reverse the remaining n - k elements
        reverseArray(arr, k, n - 1);
    }

    // Helper method to reverse elements of the array in-place
    public static void reverseArray(Object[] arr, int start, int end) {
        while (start < end) {
            Object temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Test the method with integers and characters
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7};
        Character[] charArray = {'H', 'e', 'l', 'l', 'o'};

        int k = 3;  // Number of rotations

        // Rotate integer array
        rotateArray(intArray, k);
        System.out.print("Rotated Integer Array: ");
        for (int num : intArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Rotate character array
        rotateArray(charArray, k);
        System.out.print("Rotated Character Array: ");
        for (char ch : charArray) {
            System.out.print(ch + " ");
        }
    }
}

