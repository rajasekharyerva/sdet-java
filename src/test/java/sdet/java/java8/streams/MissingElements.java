package sdet.java.java8.streams;

import java.util.ArrayList;
import java.util.List;

public class MissingElements {
    public static List<Integer> findMissingElements(int[] arr) {
        List<Integer> missingElements = new ArrayList<>();
        for (int i = arr[0]; i <= arr[arr.length - 1]; i++) {
            boolean isPresent = false;
            for (int num : arr) {
                if (num == i) {
                    isPresent = true;
                    break;
                }
            }
            if (!isPresent) {
                missingElements.add(i);
            }
        }
        return missingElements;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 7, 8, 10};
        List<Integer> missingElements = findMissingElements(arr);
        System.out.println(missingElements);
    }
}


