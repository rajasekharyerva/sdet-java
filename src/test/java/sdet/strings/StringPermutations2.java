package sdet.strings;

public class StringPermutations2 {
    public static void main(String[] args) {
        String str = "AJSFE";
        System.out.println("All permutations of the string are:");
        permute(str, "");
    }

    // Recursive function to generate permutations
    public static void permute(String str, String prefix) {
        //System.out.println("String: " + str + ", Prefix: " + prefix);
        // Base condition: if the input string is empty
        if (str.isEmpty()) {
            System.out.println(prefix);
            return;
        }

        // Recursive step: iterate through each character
        for (int i = 0; i < str.length(); i++) {
            // Current character
            char currentChar = str.charAt(i);
            // Remaining string after removing the current character
            String remaining = str.substring(0, i) + str.substring(i + 1);
            System.out.print("String: " + str + ", Remaining: " + remaining + ", Prefix: " + prefix + ", Current Char: " + currentChar + "\n");
            // Recursive call

            permute(remaining, prefix + currentChar);
        }
    }
}

