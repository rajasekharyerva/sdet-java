package sdet;

public class StringToInteger {
    public static int convertStringToInt(String str) {
        // Handle null or empty string
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Input string is null or empty");
        }

        int result = 0;
        boolean isNegative = false;
        int startIndex = 0;

        // Check for a negative sign
        if (str.charAt(0) == '-') {
            isNegative = true;
            startIndex = 1; // Skip the negative sign for processing
        }

        for (int i = startIndex; i < str.length(); i++) {
            char c = str.charAt(i);

            // Validate character is a digit
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("Invalid character found: " + c);
            }

            // Calculate the digit's value
            int digit = c - '0';

            // Build the number
            result = result * 10 + digit;
        }

        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        String input = "-12345";
        int t=-2;
        System.out.println(t);
        try {
            int number = convertStringToInt(input);
            System.out.println("Converted number: " + number);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
