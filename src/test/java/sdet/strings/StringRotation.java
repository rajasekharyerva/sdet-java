package sdet.strings;

public class StringRotation {
    public static void main(String[] args) {
        String input = "Persistant"; // lloHe - 3
        int len = input.length();
        String output = input.substring(3).concat(input.substring(0, 3));
        System.out.println(output);
    }
}
