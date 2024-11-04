package sdet.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramCheck {
    public static void main(String[] args) {
        String input1 = "tomato";
        String input2 = "matoto";

        System.out.println(areAnagrams(input1, input2));
        areAnagrams2(input1,input2);

    }

    private static boolean areAnagrams2(String input1, String input2) {
        Map<Character, Integer> chMap = new HashMap<>();
        for(char ch:input1.toCharArray()){
            chMap.put(ch, chMap.getOrDefault(ch, 0)+1);
        }

        for(char ch:input2.toCharArray()) {
            if(!chMap.containsKey(ch)) {
                return false;
            }
            chMap.put(ch, chMap.get(ch) - 1);
            if (chMap.get(ch) == 0) {
                chMap.remove(ch);
            }
        }
        return chMap.isEmpty();
    }

    private static boolean areAnagrams(String input1, String input2) {
        // Length check
        if(input2.length() != input1.length()) {
            return false;
        }
        char[] a1 = input1.toCharArray();
        char[] a2 = input2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }
}
