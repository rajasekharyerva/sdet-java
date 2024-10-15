package sdet;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysRemoveExample {
    public static void main(String args[]) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4); // Corrected line
        a.removeAll(new ArrayList<>(Arrays.asList(1, 3, 4, 5)));
        System.out.println(a);
    }
}
