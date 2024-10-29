package sdet;

import java.util.Scanner;

public class CapitalizeWords {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String first= String.valueOf(sc.nextLine());
        String middle= String.valueOf(sc.nextLine());
        String surname= String.valueOf(sc.nextLine());

        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(Character.toUpperCase(first.charAt(0))).append(first.substring(1)).append(" ")
                .append(Character.toUpperCase(middle.charAt(0))).append(middle.substring(1)).append(" ")
                .append(Character.toUpperCase(surname.charAt(0))).append(surname.substring(1)));


    }
}
