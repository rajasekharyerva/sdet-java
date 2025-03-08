package programs;

import java.util.Arrays;

public class AnagramCheck {
    public static void main(String[] args) {

        String input = "anka";
        String input2 = "akana";
        System.out.println(anaCheck(input, input2));
    }

    public static boolean anaCheck(String input, String input2) {
        if (input.length() != input2.length())
            return false;

        char[] array1 = input.toCharArray();
        char[] array2 = input2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        return Arrays.equals(array1, array2);
    }
}
