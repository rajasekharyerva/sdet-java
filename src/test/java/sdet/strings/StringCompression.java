package sdet.strings;

public class StringCompression {
    public static String compressString(String input) {
        StringBuilder result = new StringBuilder();
        int length = input.length();

        for (int i = 0; i < length; i++) {
            char currentChar = input.charAt(i);
            int count = 1;

            // Count consecutive occurrences of the current character
            while (i + 1 < length && input.charAt(i + 1) == currentChar) {
                i++;
                count++;
            }

            // Append the character and its count (if greater than 1)
            result.append(currentChar);
            if (count > 1) {
                result.append(count);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "aaabbbacfwww";
        String output = compressString(input);
        System.out.println(output);  // Output: a3b3acfw3
    }
}

