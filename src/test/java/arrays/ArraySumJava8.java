package arrays;

import java.util.Arrays;

public class ArraySumJava8 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 7, 8, 5, 9};
        System.out.println(Arrays.stream(arr).sum());
    }

}
