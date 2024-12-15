package sdet.arrays;

public class Sort012Array {

    // Function to sort the array containing 0s, 1s, and 2s
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap nums[low] and nums[mid], increment low and mid
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // If 1, just move mid forward
                mid++;
            } else {
                // Swap nums[mid] and nums[high], decrement high
                swap(nums, mid, high);
                high--;
            }
        }
    }

    // Helper function to swap two elements in the array
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    // Main function to test the sorting
    public static void main(String[] args) {
        int[] nums = {2, 0, 1, 2, 1, 0};
        sortColors(nums);

        // Print the sorted array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

