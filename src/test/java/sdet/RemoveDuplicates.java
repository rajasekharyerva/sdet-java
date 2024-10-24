package sdet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = removeDuplicates(nums);

        // Output the result
        System.out.println("Number of unique elements: " + k);
        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        // Print remaining elements as underscore
        for (int i = k; i < nums.length; i++) {
            System.out.print("_ ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // Pointer for the last unique element found

        // Iterate through the array
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++; // Move to the next position for unique element
                nums[i] = nums[j]; // Update the unique element position
            }
        }
        return i + 1; // Return the count of unique elements
    }
}

