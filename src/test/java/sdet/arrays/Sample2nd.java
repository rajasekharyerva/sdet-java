package sdet.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Sample2nd {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 1, 4, 5, 3));
        /*Collections.sort(list);
        System.out.println(list.get(list.size() - 2));*/
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int num : list) {
            if (num > max) {
                max2 = max;
                max = num;
            } else if (num < max & num > max2) {
                max2 = num;
            }
        }
        System.out.println(max2);
    }
}
