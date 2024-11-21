package sdet.strings;

import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        String input = sc.nextLine();

        // Check if the string is a palindrome
        if (isPalindrome(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }

        // Check if the string is a palindrome
        if (isPalindrome2(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }

    }

    private static boolean isPalindrome2(String input) {
        StringBuilder output = new StringBuilder(input);
        output.reverse();
        return input.contentEquals(output.toString());
    }

    // Method to check if the string is a palindrome
    public static boolean isPalindrome(String str) {
        // Convert the string to lowercase to make the check case-insensitive
        str = str.toLowerCase();

        // Initialize two pointers
        int left = 0;
        int right = str.length() - 1;

        // Check characters from both ends
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Not a palindrome if characters don't match
            }
            left++;
            right--;
        }
        return true; // It's a palindrome if all characters match
    }
}
