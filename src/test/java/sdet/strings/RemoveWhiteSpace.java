package sdet.strings;

public class RemoveWhiteSpace {
    public static void main(String[] args) {
        String originalString = "This is a string with spaces!";

        // Remove all whitespaces using replaceAll
        String stringWithoutSpaces = originalString.replaceAll("\\s+", "");

        // Output the result
        System.out.println("Original String: " + originalString);
        System.out.println("String Without Spaces: " + stringWithoutSpaces);
    }
}

