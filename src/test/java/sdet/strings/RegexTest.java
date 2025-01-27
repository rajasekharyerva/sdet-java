package sdet.strings;


import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        String input = "asdd#$*@?";
        for (char ch : input.toCharArray()) {
            if (Pattern.matches("[a-zA-Z0-9\\s#$*@]", Character.toString(ch))) {
                System.out.print(ch);
            }
        }
    }
}
