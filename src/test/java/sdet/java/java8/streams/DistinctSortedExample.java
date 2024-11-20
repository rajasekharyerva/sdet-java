package sdet.java.java8.streams;

import java.util.Arrays;
import java.util.List;

public class DistinctSortedExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 2, 3, 1, 2, 4, 5, 1);

        // Remove duplicates and sort
        List<Integer> uniqueSortedNumbers = numbers.stream()
                .distinct()
                .sorted()
                .toList();
        System.out.println("Unique and Sorted: " + uniqueSortedNumbers);
    }
}
