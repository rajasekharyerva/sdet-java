package sdet;

import java.util.Scanner;

public class Palindrome {
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        String input = sc.nextLine();

        StringBuilder output = new StringBuilder(input);
        output.reverse();
        System.out.println(output);
        if(input.equals(output.toString())) {
            System.out.println("Palindrome");
        }
    }
}
