package sdet.java.java8.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByExample {
    public static void main(String[] args) {
        List<String> items = List.of("Apple.txt", "Banana", "Cherry", "Avocado", "Blueberry");

        // Group items by their starting letter
        Map<Character, List<String>> groupedByFirstLetter = items.stream()
                .collect(Collectors.groupingBy(item -> item.charAt(0)));
        System.out.println("Grouped by first letter: " + groupedByFirstLetter);
    }
}

