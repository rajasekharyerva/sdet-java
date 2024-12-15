package sdet.arrays;

import java.util.*;

public class SortLargest2 {

    /*
    Input:
    arr = [3, 2, 1, 5, 6, 4]
    k = 2
    Output:
    5
    */
    public static void main(String[] args) {
        int[] array = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int kthLargestElement = findKthLargestElement(array, k);
        //System.out.println(kthLargestElement);
        int[] array2 = {4, -3, 2, 1, 6, -4, -2, 3, 5};
        int currentSum = 0;
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        for (int i = 0; i < array2.length; i++) {
            currentSum = currentSum + array2[i];
            sumMap.putIfAbsent(currentSum, new ArrayList<>());
        }


    }

    private static int findKthLargestElement(int[] array, int k) {
        Arrays.sort(array);
        return array[array.length - k];
    }
}
