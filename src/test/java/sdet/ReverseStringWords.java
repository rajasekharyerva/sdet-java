package sdet;

import java.util.Scanner;

public class ReverseStringWords {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputArray = input.split(" ");
        String output = "";

        for(int i=inputArray.length-1;i>=0;i--){
            output+=inputArray[i]+" ";
        }

        System.out.println(input+" "+output.trim());
    }
}
