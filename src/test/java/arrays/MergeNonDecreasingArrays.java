package arrays;

import java.util.Arrays;

public class MergeNonDecreasingArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        mergeArr(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));  // Output: [1, 2, 2, 3, 5, 6]
    }

    private static void mergeArr(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;  // Pointer for the last initialized element in nums1
        int j = n - 1;  // Pointer for the last element in nums2
        int k = m + n - 1;  // Pointer for the last position in nums1

        // Merge in reverse order
        while (i >= 0 && j >= 0) {
            System.out.println(nums1[i] + "-" + nums2[j] + "-" + nums1[k]);
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If there are remaining elements in nums2, copy them
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
