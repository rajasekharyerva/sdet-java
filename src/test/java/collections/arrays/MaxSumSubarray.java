package collections.arrays;

public class MaxSumSubarray {
    public static int findMaxSumSubarray(int[] nums) {
        int currentMax = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], nums[i] + currentMax);
            maxSum = Math.max(maxSum, currentMax);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = findMaxSumSubarray(nums);
        System.out.println("Maximum Sum of Subarray: " + maxSum);
    }
}

