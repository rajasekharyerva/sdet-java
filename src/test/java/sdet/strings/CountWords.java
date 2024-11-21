package sdet.strings;

public class CountWords {
    public static void main(String[] args) {
        // Sample string
        String sentence = "This is an example sentence to count words";

        // Split the string by spaces
        String[] words = sentence.split("\\s+");

        // Count the number of words
        int wordCount = words.length;

        // Print the result
        System.out.println("Number of words in the sentence: " + wordCount);
    }
}
