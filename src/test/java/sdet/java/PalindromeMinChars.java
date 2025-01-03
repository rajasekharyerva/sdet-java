package sdet.java;

public class PalindromeMinChars {

    public static int minCharsToMakePalindrome(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        String concat = s + "$" + rev;

        // Compute LPS array
        int[] lps = new int[concat.length()];
        int j = 0; // length of the previous longest prefix suffix

        for (int i = 1; i < concat.length(); i++) {
            while (j > 0 && concat.charAt(i) != concat.charAt(j)) {
                j = lps[j - 1];
            }
            if (concat.charAt(i) == concat.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        // Minimum characters to add
        return n - lps[concat.length() - 1];
    }

    public static void main(String[] args) {
        String s = "abacd";
        int result = minCharsToMakePalindrome2(s);
        System.out.println("Number of Characters to add: " + result);
    }

    public static int minCharsToMakePalindrome2(String s) {
        int n = s.length();
        int i = 0, j = n - 1, charsToAdd = 0;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                charsToAdd++;
                i = 0;
                j = n - charsToAdd - 1;
            }
        }

        return charsToAdd;
    }
}
