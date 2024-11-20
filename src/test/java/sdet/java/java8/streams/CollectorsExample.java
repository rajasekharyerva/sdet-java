package sdet.java.java8.streams;

import java.util.List;
import java.util.stream.Collectors;

public class CollectorsExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Count elements
        long count = numbers.stream()
                .collect(Collectors.counting());
        System.out.println("Count: " + count);

        // Sum elements
        int sum = numbers.stream()
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Sum: " + sum);
    }
}

