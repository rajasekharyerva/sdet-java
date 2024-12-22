package grid.dynamics;

public class PrintOccurenceNTimes {
    public static void main(String[] args) {
            /*
            Input: a2b1c3d1
            Output: aabcccd
            */
        StringBuilder result = new StringBuilder();
        //String input="a2b1c3d1";
        String input = "raja2boss1cons3dons1";
        int i = 0;
        while (i < input.length()) {
            //get cuurent
            //char current = input.charAt(i);
            StringBuilder wordBuilder = new StringBuilder();
            while (i < input.length() && !Character.isDigit(input.charAt(i))) {
                wordBuilder.append(input.charAt(i));
                i++;
            }

            StringBuilder numBuilder = new StringBuilder();
            while (i < input.length() && Character.isDigit(input.charAt(i))) {
                numBuilder.append(input.charAt(i));
                i++;
            }

            int number = Integer.parseInt(numBuilder.toString());
            while (number >= 1) {
                result.append(wordBuilder);
                number--;
            }
        }
        System.out.println(result.toString());

    }
}
