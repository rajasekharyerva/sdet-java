package sdet.strings;

public class RemoveLeadingZeros {
    public static void main(String[] args) {
        String input = "00012345";

        // Remove leading zeros using regex
        String result = removeLeadingZeros(input);

        System.out.println("Original String: " + input);
        System.out.println("String Without Leading Zeros: " + result);
    }

    // Method to remove leading zeros
    public static String removeLeadingZeros(String input) {
        return input.replaceAll("^0+", "");
    }
}

