package com.example;

import java.util.Arrays;
import java.util.Collections;

public class RemoveDuplicatesBruteForce {
    public static void main(String[] args) {
        int[] a = {30, 78, 55, 39, 26, 99, 78, 55, 99, 30};
        int[] res = removeDuplicates(a);
        Arrays.sort(res);
        for (int s : res) {
            System.out.println(s);
        }
    }

    private static int[] removeDuplicates(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    array[j] = 0;
                }
            }
        }

        //get index
        int index = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == 0) {
                index = i;
                break;
            }
        }

        int[] result = new int[index];

        for (int i = 0; i < index; i++) {
            result[i] = array[i];
        }


        return result;
    }
}
