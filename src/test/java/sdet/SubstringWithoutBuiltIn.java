package sdet;

public class SubstringWithoutBuiltIn {

    public static void main(String[] args) {
        String str = "Automation Testing Software Engineer";
        String targetSubstring = "Testing Software Engineer";
        String result = extractSubstring(str, targetSubstring);

        System.out.println(result);
    }

    // Method to extract substring manually
    public static String extractSubstring(String str, String target) {
        // Find the starting index of the target substring
        int startIndex = 0;
        int targetLength = target.length();

        // Loop through the original string to find the starting index
        for (int i = 0; i < str.length(); i++) {
            boolean matchFound = true;

            // Check for match
            for (int j = 0; j < targetLength; j++) {
                if (i + j >= str.length() || str.charAt(i + j) != target.charAt(j)) {
                    matchFound = false;
                    break;
                }
            }

            // If match is found, set the starting index
            if (matchFound) {
                startIndex = i;
                break;
            }
        }

        // Build the resulting substring from the start index
        StringBuilder substring = new StringBuilder();
        for (int i = startIndex; i < str.length(); i++) {
            substring.append(str.charAt(i));
        }

        return substring.toString();
    }
}

