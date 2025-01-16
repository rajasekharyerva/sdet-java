package sdet;

import java.util.Arrays;

public class SampleTest {
    public static void main(String[] args) {
        //missingNumbers();
        //swapNumberz();
        //reverseStr();
        //System.out.println(factRec(5));
        //secLargest();
        //fibSeries();
        sortWO();

    }

    private static void sortWO() {
        int[] array = {64, 25, 12, 22, 11};
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    private static void fibSeries() {
        int n = 5;
        int prev1 = 0;
        int prev2 = 1;
        for (int i = 1; i <= n; i++) {
            int cur = prev1 + prev2;
            System.out.println(cur);
            prev1 = prev2;
            prev2 = cur;
        }
    }

    private static void secLargest() {
        int[] intArr = {3, 2, 7, 8, 9, 1, 5};
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int n : intArr) {
            if (n > first) {
                second = first;
                first = n;
            } else if (n > second && n < first) {
                second = n;
            }

        }
        System.out.println(second);
    }

    private static int factRec(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factRec(n - 1);
    }

    private static void reverseStr() {
        var str = "skdjbfknf";
        var sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        System.out.println(sb);
    }

    private static void swapNumberz() {
        int a = 5;
        int b = 2;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a);
        System.out.println(b);
    }

    private static void missingNumbers() {
        int[] intArray = {1, 2, 4, 7, 9};
        int start = intArray[0];
        int end = intArray[intArray.length - 1];
        int index = 1;
        for (int i = start; i < end; i++) {
            if (intArray[index] == i) {
                index++;
            } else {
                System.out.println(i);
            }
        }
    }
}
