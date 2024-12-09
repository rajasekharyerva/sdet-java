package sdet.strings;

import java.util.HashSet;

public class PangramCheck {
    public static boolean isPangram(String sentence) {
        // Convert the sentence to lowercase
        sentence = sentence.toLowerCase();

        // Use a HashSet to track unique characters
        HashSet<Character> uniqueChars = new HashSet<>();

        // Iterate through the string
        for (char ch : sentence.toCharArray()) {
            // Add only alphabetic characters to the set
            if (ch >= 'a' && ch <= 'z') {
                //System.out.println(ch);
                uniqueChars.add(ch);
            }
        }

        // Check if the set contains all 26 letters
        return uniqueChars.size() == 26;
    }

    public static void main(String[] args) {
        String input = "The quick brown fox jumps over the lazy dog";
        System.out.println("Is pangram: " + isPangram(input));

        String in = "A man, a plan, a canal: Panama";
        in = in.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        System.out.println(in);
    }
}
