package sdet.strings;

public class BreakPalindrome3 {
    public static void main(String[] args) {
        String input="bbb";
        System.out.println(breakPalindromePreviousChar(input));
    }

    private static String breakPalindromePreviousChar(String input) {
        char[] alphabet = new char[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('a' + i);
        }
        String x = "";

        for (int i=0; i<input.length()/2;i++){
            char ch = input.charAt(i);
            if('a' != ch){
                char replaceChar = (char)(ch-1);
                return x.concat(Character.toString(replaceChar)).concat(input.substring(i+1));
            }
        }

        return x.concat(input.substring(0,input.length()-1)).concat(Character.toString('b'));
    }
}
