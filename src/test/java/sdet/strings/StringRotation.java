package sdet.strings;

public class StringRotation {
    public static void main(String[] args) {
        String input = "Hello"; // lloHe
        int len = input.length();
        String output = input.substring(2).concat(input.substring(0,2));
        System.out.println(output);
    }
}
