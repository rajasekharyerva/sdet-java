package sdet.strings;

public class ReverseWord {
    public static void main(String args[]) {
        String input = "I am a boy";
        StringBuilder sbReverse = new StringBuilder(input);

        System.out.println(reverseStringCharAt(input));
        System.out.println(reverseStringStringBuilderAppend(input));
        System.out.println(reverseStringCharArray(input));
        System.out.println(sbReverse.reverse());
    }

    private static StringBuilder reverseStringStringBuilderAppend(String input) {
        StringBuilder sb = new StringBuilder();
        for(int i=input.length()-1; i>=0;i--){
            sb.append(input.charAt(i));
        }
        return sb;
    }

    private static String reverseStringCharAt(String input) {
        String output="";
        for(int i=input.length()-1; i>=0;i--){
            output=output + input.charAt(i);
        }
        return output;
    }

    // Method to reverse a string using a loop
    public static String reverseStringCharArray(String str) {
        char[] charArray = str.toCharArray();
        String reversedStr = "";

        // Loop to append characters in reverse order
        for (int i = charArray.length - 1; i >= 0; i--) {
            reversedStr += charArray[i];
        }

        return reversedStr;
    }
}
