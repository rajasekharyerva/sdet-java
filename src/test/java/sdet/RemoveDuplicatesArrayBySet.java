package sdet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesArrayBySet {
    public static void main(String[] args) {
        Integer [] numbers = {1, 2, 5, 4, 5, 4, 4};
        Set<Integer> set = new HashSet<>(Arrays.asList(numbers));
        System.out.println(set);
    }
}
