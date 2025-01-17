package sdet.strings.palindrome;

public class MergeArrays {
    public static void main(String[] args) {
        char[] s1 = {'A', 'B', 'C', 'D', 'E', 't', 'Z'};
        char[] s2 = {'c', 'd', 'e', 'f'};

        int maxLength = Math.max(s1.length, s2.length);
        char[] result = new char[s1.length + s2.length];
        int index = 0;

        for (int i = 0; i < maxLength; i++) {
            if (i < s1.length) {
                // For characters in s1, alternate between original and lowercase
                result[index++] = Character.toLowerCase(s1[i]);
            }
            if (i < s2.length) {
                // For characters in s2, alternate between original and uppercase
                result[index++] = Character.toUpperCase(s2[i]);
            }
        }

        // Print the result array
        System.out.println("Result: " + new String(result));
    }
}

