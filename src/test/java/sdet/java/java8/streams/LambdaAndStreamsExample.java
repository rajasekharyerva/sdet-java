package sdet.java.java8.streams;

import java.util.Arrays;
import java.util.List;

public class LambdaAndStreamsExample {
    public static void main(String[] args) {
        // Step 1: Create a list of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Step 2: Use streams and lambdas to filter, map, and collect
        List<Integer> processedNumbers = numbers.stream()
                .filter(n -> n % 2 == 0) // Filter even numbers
                .map(n -> n * 2)         // Multiply each by 2
                .toList(); // New list

        // Step 3: Print the result
        System.out.println("Processed Numbers: " + processedNumbers);
    }
}

