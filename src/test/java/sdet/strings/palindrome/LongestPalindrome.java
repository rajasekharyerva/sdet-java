package sdet.strings.palindrome;

public class LongestPalindrome {
    public static void main(String[] args) {
        String input = "abfgerccdedccfgfer";
        String longestPalindrome = findLongestPalindrome(input);
        System.out.println("Longest palindrome: " + longestPalindrome);
    }

    private static String findLongestPalindrome(String str) {
        if (str == null || str.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < str.length(); i++) {
            int len1 = expandAroundCenter(str, i, i);        // Odd-length palindromes
            int len2 = expandAroundCenter(str, i, i + 1);    // Even-length palindromes
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return str.substring(start, end + 1);
    }

    private static int expandAroundCenter(String str, int left, int right) {
        // System.out.println("Checking: " + left + " >=0 " + right + " < length " + str.charAt(left) + "==" + str.charAt(right));
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

