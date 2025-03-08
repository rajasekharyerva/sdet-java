package collections.arrays;

import java.util.Arrays;

public class ShiftEvenOdd {
    public static void main(String[] args) {
        int[] numbers = {3, 2, 0, 8, 1, 9, 4, 7, 5, 6};
        int length = numbers.length;
        int[] result = new int[length];
        int start = 0;
        int end = numbers.length - 1;
        int index = 0;
        while (start <= end) {
            if (numbers[index] % 2 == 0) {
                result[start] = numbers[index];
                start++;
            } else {
                result[end] = numbers[index];
                end--;
            }
            index++;
        }
        System.out.println(Arrays.toString(result));
    }
}
