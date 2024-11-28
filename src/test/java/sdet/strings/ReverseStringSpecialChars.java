package sdet.strings;

public class ReverseStringSpecialChars {
    public static String reverseWithoutSpecialChars(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            // Skip special characters
            if (!Character.isLetterOrDigit(chars[left])) {
                left++;
            } else if (!Character.isLetterOrDigit(chars[right])) {
                right--;
            } else {
                // Swap characters
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String input = "a,b$c";
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reverseWithoutSpecialChars(input));
    }
}

