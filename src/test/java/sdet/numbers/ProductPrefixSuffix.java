package sdet.numbers;

import java.util.Arrays;

public class ProductPrefixSuffix {
    public static void main(String[] args) {
        /*
        Input: nums = [1,2,3,4]
        Output: [24,12,8,6]
        */
        int[] array = {4, 3, 2, 4};
        nestedLoop(array);
        twoPointer(array);

    }

    private static void twoPointer(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Calculate left products
        answer[0] = 1; // No elements to the left of the first element
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate right products and update the answer array
        int rightProduct = 1; // No elements to the right of the last element
        for (int i = n - 2; i >= 0; i--) {
            rightProduct = rightProduct * nums[i + 1];
            answer[i] = answer[i] * rightProduct;
        }

        System.out.println(Arrays.toString(answer));
    }

    public static void nestedLoop(int[] array) {

        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int prodcut = 1;
            for (int j = 0; j < array.length; j++) {
                if (i != j) {
                    prodcut = prodcut * array[j];
                }
            }
            result[i] = prodcut;
        }
        System.out.println(Arrays.toString(result));
    }

}
