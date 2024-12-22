package sdet.strings;

public class NonRepeatingChar {
    public static void main(String[] args) {
        String input = "";
        System.out.println(foundRepeating(input));

    }

    private static int foundRepeating(String input) {
        for (int i = 0; i < input.length(); i++) {
            boolean isRepeating = false;
            for (int j = 0; j < input.length(); j++) {
                if (i != j & input.charAt(i) == input.charAt(j)) {
                    isRepeating = true;
                    break;
                }
            }

            if (!isRepeating) {
                return i;
            }
        }
        return -1;
    }
}
