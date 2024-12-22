package sdet.strings;

import java.util.Arrays;

public class ZeroShift {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12, 0, 4};
        int nz = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[nz] = arr[i];
                nz++;
            }
        }
        while (nz < arr.length) {
            arr[nz] = 0;
            nz++;
        }
        System.out.println(Arrays.toString(arr));
    }
}
