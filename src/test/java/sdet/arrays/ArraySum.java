package sdet.arrays;

import java.util.Arrays;

public class ArraySum {
    public static void main(String[] args) {
        int [] arr = {2,4,4,7,8,5,9};
        System.out.println(Arrays.stream(arr).sum());
    }

}
