package streams;

import java.util.List;
import java.util.Optional;

public class FindExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");

        // Find first element
        Optional<String> first = names.stream().findFirst();
        System.out.println("First name: " + first.orElse("No name found"));

        // Find any element
        Optional<String> anyName = names.stream().findAny();
        System.out.println("Any name: " + anyName.orElse("No name found"));
    }
}

