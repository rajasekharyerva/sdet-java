package sdet.strings;

public class StringToInteger {
    public static void main(String[] args) {
        String str = "12345";
        int result = stringToInt(str);
        System.out.println("Converted Integer: " + result);
    }

    public static int stringToInt(String str) {
        int result = 0;
        int sign = 1;
        int i = 0;

        // Handle negative numbers
        if (str.charAt(0) == '-') {
            sign = -1;
            i = 1; // Start from the second character
        }

        // Traverse each character of the string
        for (; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Check if the character is a valid digit
            if (ch < '0' || ch > '9') {
                throw new NumberFormatException("Invalid character found: " + ch);
            }

            // Update the result
            result = result * 10 + (ch - '0');
        }

        return result * sign;
    }
}

