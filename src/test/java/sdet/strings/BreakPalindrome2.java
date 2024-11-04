package sdet.strings;

public class BreakPalindrome2 {
    public static String breakPalindrome(String palindrome) {
        // If the length of the palindrome is 1, it's impossible to break it
        if (palindrome.length() == 1) {
            return "";
        }

        char[] chars = palindrome.toCharArray();
        StringBuilder sb = new StringBuilder();

        // Traverse the first half of the palindrome
        for (int i = 0; i < chars.length / 2; i++) {
            // If we find a character that is not 'a', replace it with 'a'
            if(palindrome.charAt(i) > 'a') {
                sb.append(palindrome.substring(0,i)).append(sb.append('a').append(palindrome.substring(i)));
                System.out.println(sb);
            } else {
                System.out.println("do nothing");
            }
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return new String(chars);
            }
        }

        // If we reach here, the string was all 'a's, so change the last character to 'b'
        chars[chars.length - 1] = 'b';
        return new String(chars);
    }

    public static void main(String[] args) {
        String palindrome = "bab";
        String result = breakPalindrome(palindrome);
        System.out.println("Result: " + result); // Expected output: "aaccba"
    }
}

