package sdet.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateCharsString {
    public static void main(String[] args) {
        String input = "this is a sample string";
        System.out.println(removeDuplicatesList(input));
        System.out.println(removeDuplicatesSet(input));
    }

    private static String removeDuplicatesSet(String input) {
        Set<Character> charSet = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (!charSet.contains(c)) {
                charSet.add(c);             // Add character to set if not seen
                result.append(c);        // Append character to result
            }
        }

        return result.toString();
    }

    private static String removeDuplicatesList(String input) {
        char[] charArray = input.toCharArray();

        List<Character> charList = new ArrayList<>();
        for(char ch:charArray) {
            if (!charList.contains(ch)) {
                charList.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch: charList) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
