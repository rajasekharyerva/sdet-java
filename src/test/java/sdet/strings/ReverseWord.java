package sdet.strings;

public class ReverseWord {
    public static void main(String args[]) {
        String input = "I am a boy";
        StringBuilder sbReverse = new StringBuilder(input);

        System.out.println(reverseStringCharAt(input));
        System.out.println(reverseStringStringBuilderAppend(input));
        System.out.println(reverseStringCharArray(input));
        System.out.println(sbReverse.reverse());
        System.out.println(reverseString(input));
    }

    private static StringBuilder reverseStringStringBuilderAppend(String input) {
        StringBuilder sb = new StringBuilder();
        for(int i=input.length()-1; i>=0;i--){
            sb.append(input.charAt(i));
        }
        return sb;
    }

    private static String reverseStringCharAt(String input) {
        StringBuilder output= new StringBuilder();
        for(int i=input.length()-1; i>=0;i--){
            output.append(input.charAt(i));
        }
        return output.toString();
    }

    // Method to reverse a string using a loop
    public static String reverseStringCharArray(String str) {
        char[] charArray = str.toCharArray();
        StringBuilder reversedStr = new StringBuilder();

        // Loop to append characters in reverse order
        for (int i = charArray.length - 1; i >= 0; i--) {
            reversedStr.append(charArray[i]);
        }

        return reversedStr.toString();
    }

    // Method to reverse the string
    public static String reverseString(String str) {
        char[] charArray = str.toCharArray();  // Convert string to char array
        int start = 0;
        int end = charArray.length - 1;

        // Swap characters from start and end until they meet in the middle
        while (start < end) {
            // Swap characters
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;

            // Move the pointers towards the center
            start++;
            end--;
        }

        // Convert the char array back to string
        return new String(charArray);
    }
}
