package sdet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateCharsString {
    public static void main(String[] args) {
        String input = "this is a sample string";
        char[] charArray = input.toCharArray();
        Set<Character> charSet = new HashSet<>();
        List<Character> charList = new ArrayList<>();
        for(char ch:charArray) {
            if (!charList.contains(ch)) {
                charList.add(ch);
            }
        }

        for(char ch: charList) {
            System.out.print(ch);
        }

    }
}
