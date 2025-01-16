package com.example;

public class PrintFirstLastCharacter {
    public static void main(String[] args) {
        //String str = "Hello Good Morning World"
        //print first letter and last letter from each word
        //Ho Gd Mg Wd
        String input = "Hello Good Morning World";
        String[] inputArray = input.split(" ");
        StringBuilder result = new StringBuilder();
        for (String str : inputArray) {
            int length = str.length();
            result.append(str.substring(0, 1)).append(str.substring(length - 1, length));
        }

        System.out.println(result.toString());
    }
}
