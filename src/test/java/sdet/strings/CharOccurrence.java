package sdet.strings;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class CharOccurrence {
    public static void main(String[] args) {
        String input = "To DO or Not to dO";
        Map<Character, Integer> charMap = new HashMap<>();
        char[] charArray = input.toCharArray();
        for (char ch : charArray) {
            char chIgnoreCase = Character.toUpperCase(ch);
            charMap.put(chIgnoreCase, charMap.getOrDefault(chIgnoreCase, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            //if (entry.getValue() > 1) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            //}
        }

        Faker faker = new Faker();
        
        System.out.println(faker.random().nextInt(1, 100));
        double d = Math.random() * 10000;
        System.out.println(d);
        System.out.println(Math.floor(d));
        System.out.println(Math.ceil(d));
    }
}
