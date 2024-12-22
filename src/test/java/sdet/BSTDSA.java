package sdet;

import java.util.Arrays;

public class BSTDSA {
    public static void main(String[] args) {
        int[] inputArray = {3, 29, 31, 2, 98, 4};
        Arrays.sort(inputArray);
        System.out.println(bst(inputArray, 29));
    }

    private static int bst(int[] sortedArray, int value) {
        int low = 0;
        int high = sortedArray.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedArray[mid] == value) {
                return mid;
            } else if (value < sortedArray[mid]) {
                high = mid - 1;
            } else if (value > sortedArray[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }

}
