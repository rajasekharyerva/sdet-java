// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        //Input : Automation
        //Output : Automin
        //HashMap
        String input = "Automation";
        //String input2 = input.toUpperCase();
        //System.out.println(input2);
        String output ="";
        //StringBuilder output = new StringBuilder();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        List<Character> list = new ArrayList<>();
        char[] charArray = input.toCharArray();
        for(int i=0; i<charArray.length; i++) {
            //Check for ignoreCase
            //System.out.println(Character.toUpperCase(charArray[i]));
            //System.out.println(input.charAt(i));
            if(!list.contains(Character.toUpperCase(charArray[i]))) {
                list.add(Character.toUpperCase(charArray[i]));
                output=output+charArray[i];
            }
        }


        System.out.println(output);

    }
}