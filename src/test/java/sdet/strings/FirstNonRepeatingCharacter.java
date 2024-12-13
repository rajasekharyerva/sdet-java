package sdet.strings;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "TeeTotaler";
        char result = findFirstNonRepeating(str);

        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }

    public static char findFirstNonRepeating(String str) {
        for (int i = 0; i < str.length(); i++) {
            boolean isRepeating = false;

            // Compare the current character with every other character in the string
            for (int j = 0; j < str.length(); j++) {
                if (i != j && str.charAt(i) == str.charAt(j)) {
                    isRepeating = true;
                    break; // If found repeating, no need to check further
                }
            }

            // If the character is not repeating, return it
            if (!isRepeating) {
                return str.charAt(i);
            }
        }

        return '\0'; // Return null character if no non-repeating character is found
    }
}

