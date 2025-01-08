package sdet.java;

import java.util.*;

public class StringPrograms {
    public static void main(String[] args) {
        //countVowelsAndConstants();
        //checkStringPalindrome();
        //removeDuplicatesString();
        //firstNonRepeatedCharacter();
        //countOccurrencesCharInAString();
        //checkAnagrams();
        //convertStringToInteger();
        // reverseVowels();
    }

    private static void reverseVowels() {
        //4. Reverse the vowels in each word of a given string.
        //Example: str = "same hello dame" → Output: "sema holle dema"
        var str = "same hello dame";
        ArrayList<Character> vowelsList = new ArrayList<>();
        char[] charArray = str.toCharArray();
        for (char ch : charArray) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelsList.add(ch);
            }
        }
        int index = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            char ch = charArray[i];
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                charArray[i] = vowelsList.get(index);
                index++;
            }
        }

        var output = new String(charArray);
        System.out.println(output);
    }

    private static void convertStringToInteger() {
        //Convert a String to Integer (String to int): Write a program to convert a string representing a number into an integer.

        var input = "265s7";
        var charArray = input.toCharArray();
        var num = 0;
        for (char ch : charArray) {
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            } else {
                System.out.println("Input contains non numerics");
                break;
            }
        }
        System.out.println(num);
    }

    private static void checkAnagrams() {
        //Check if Two Strings are Anagrams: Write a program that checks if two strings are anagrams of each other (contain the same characters in different orders).

        var inputString = "dzjnxvnlc";
        var inputString2 = "xvnlcdzjn";
        var ch1 = inputString.toCharArray();
        var ch2 = inputString2.toCharArray();
        if (ch1.length != ch2.length) {
            System.out.println("Not anagram strings");
        }
        //Arrays.sort(ch1);
        //Arrays.sort(ch2);
        Map<Character, Integer> hashMap = new HashMap<>();
        Map<Character, Integer> hashMap2 = new HashMap<>();

        for (char ch : ch1) {
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : ch2) {
            hashMap2.put(ch, hashMap2.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (!(hashMap2.containsKey(entry.getKey()) && hashMap2.get(entry.getKey()) == entry.getValue())) {
                System.out.println("Not anagrams");
            }
        }

    }

    private static void countOccurrencesCharInAString() {
        //Count the Occurrences of a Character in a String: Write a Java function that counts how many times a specific character appears in a given string.

        var inputString = "sajfdjas";
        Map<Character, Integer> linkedHashMap = new LinkedHashMap<>();
        for (char ch : inputString.toCharArray()) {
            linkedHashMap.put(ch, linkedHashMap.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " occurrences: " + entry.getValue());
        }
    }

    private static void firstNonRepeatedCharacter() {
        //Write a program to find the first non-repeated character in a given string

        var inputString = "sajfdjas";
        Map<Character, Integer> linkedHashMap = new LinkedHashMap<>();
        for (char ch : inputString.toCharArray()) {
            linkedHashMap.put(ch, linkedHashMap.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : linkedHashMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("First Unique Character: " + entry.getKey());
                break;
            }
        }
    }

    private static void removeDuplicatesString() {
        //Write a program to remove duplicate characters from a string
        var inputString = "sajfdjas";
        StringBuilder sb = new StringBuilder();
        Set<Character> uniqueCharSet = new LinkedHashSet<>();
        for (char ch : inputString.toCharArray()) {
            if (!uniqueCharSet.contains(ch)) {
                uniqueCharSet.add(ch);
            }
        }
        for (char ch : uniqueCharSet) {
            sb.append(ch);
        }
        System.out.println(sb);
    }


    private static void checkStringPalindrome() {
        //Write a Java function that checks whether a given string is a palindrome or not
        var inputString = "sajfdjas";
        var start = 0;
        var end = inputString.length() - 1;
        var isPalindrome = true;
        while (start < end) {
            if (inputString.charAt(start) != inputString.charAt(end)) {
                System.out.println("Not a palindrome string");
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        System.out.println("Palindrome string? " + isPalindrome);
    }

    /*
     * Write a program that counts the number of vowels and consonants in a given string
     */
    private static void countVowelsAndConstants() {

        var input = "jvbsvoanqhpg";
        var vowels = 0;
        var constants = 0;
        for (char ch : input.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else if (ch > 'a' && ch <= 'z') {
                constants++;
            }
        }
        System.out.println("vowels: " + vowels);
        System.out.println("Constants: " + constants);
    }
}
