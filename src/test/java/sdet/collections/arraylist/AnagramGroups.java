package sdet.collections.arraylist;

import java.util.*;

public class AnagramGroups {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // HashMap to store sorted strings as keys and their corresponding anagrams as values
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Convert the string to a char array, sort it, and convert it back to a string
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray);

            // Add the string to the corresponding anagram group
            map.putIfAbsent(sortedKey, new ArrayList<>());
            map.get(sortedKey).add(str);
        }

        // Return all values (groups of anagrams) as a list
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(arr);
        System.out.println(result);
    }
}

