package streams;

import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // Filter names starting with 'A'
        List<String> namesStartingWithA = names.stream()
                .filter(name -> name.startsWith("A"))
                .toList();
        System.out.println("Names starting with A: " + namesStartingWithA);

        // Map names to uppercase
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Names in uppercase: " + upperCaseNames);
    }
}
