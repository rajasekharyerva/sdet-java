public class Sample {
    public static void main(String[] args) {
        /*
         Input: aaabbbacfwww
         Output: a3b3acfw3
        */
        //a3b3acfw3
        //a4cfw3
        String input = "aaabbbacfwww";
        //char[] chArray = input.toCharArray();
        StringBuilder result = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            counter = 1;
            char inputChar = input.charAt(i);
            for (int j = i + 1; j < input.length(); j++) {
                if (inputChar == input.charAt(j)) {
                    counter++;
                    i = j;
                    //break;
                }

            }
            if (counter > 1) {
                result.append(inputChar).append(counter);
            } else {
                result.append(inputChar);
            }
            System.out.println(i);
        }
        System.out.println(result);
    }
}
