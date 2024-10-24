package sdet;

public class ReverseStringTest {
    public static void main(String args[]) {
        String input = "Hello world";
        String output="";
        /*System.out.println(reverseStringConcat(input));
        System.out.println(reverseStringStringBuilder(input));*/


        StringBuilder sb = new StringBuilder();
        for(int i=input.length()-1; i>=0;i--) {
            output+=input.charAt(i);
            sb.append(input.charAt(i));
        }
        System.out.println(output);
        System.out.println(sb);

        StringBuilder sbr = new StringBuilder(input);
        System.out.println(sbr.reverse());
    }

    private static StringBuilder reverseStringStringBuilder(String input) {
        StringBuilder sb = new StringBuilder();
        for(int i=input.length()-1; i>=0;i--){
            sb.append(input.charAt(i));
        }
        return sb;
    }

    private static String reverseStringConcat(String input) {
        String output="";
        for(int i=input.length()-1; i>=0;i--){
            output=output + input.charAt(i);
        }
        return output;
    }
}
