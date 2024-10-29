package sdet;

public class CapitalizeEachWord {
    public static void main(String[] args) {
        String input = "i love india";
        convertInitCapital(input) ;
    }

    private static void convertInitCapital(String input) {
        StringBuilder sb = new StringBuilder();
        String[] inputArr = input.split(" ");
        for(String str: inputArr) {
            sb.append(Character.toUpperCase(str.charAt(0))).append(str.substring(1)).append(" ");
        }

        System.out.println(sb.toString().trim());
    }


}

