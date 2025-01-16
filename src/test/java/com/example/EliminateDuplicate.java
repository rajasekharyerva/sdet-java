package com.example;

import java.util.LinkedHashSet;
import java.util.Set;

public class EliminateDuplicate {
    public static void main(String[] args) {
        //write program to convert "I like Like to To code" into "I like to code"?
        String input = "I like Like to To code";
        //input =input.replaceAll("\\[A-Z\\]", "[a-z]");
        Set<String> stringSet = new LinkedHashSet<>();
        String[] strArray = input.split(" ");
        StringBuilder result = new StringBuilder();
        for (String str : strArray) {
            String temp = str.toLowerCase();
            if (!stringSet.contains(temp)) {
                stringSet.add(temp);
                result.append(str).append(" ");
            }
        }
        System.out.println(result.toString().trim());
    }
}
