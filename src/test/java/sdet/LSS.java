package sdet;

public class LSS {
    public static void main(String[] args) {
        /*
        Input: "abcabcbb"
        Output: 3
        */
        String input = "abcabcbb";
        int max = 0;
        String maxSubString = "";

        for (int i = 0; i < input.length() - 1; i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    if (j - i > max) {
                        max = j - i;
                        maxSubString = input.substring(i, j);
                        break;
                    } else if (j - i == max) {
                        break;
                    }
                }
            }
        }
        System.out.println(maxSubString);
    }
}
