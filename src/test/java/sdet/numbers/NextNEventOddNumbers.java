package sdet.numbers;

import java.util.Scanner;

public class NextNEventOddNumbers {

  /*Given two numbers 3,6.
    Print the next 6 even numbers after 3, along with 3.
    Print the next 6 odd numbers after 3, along with 3.*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int counter = sc.nextInt();
        if(input%2==0) {
            System.out.print(input);
            for(int i=1; i<counter+1;i++){
                System.out.print((input+1)+(2*i));
            }
        } else {
            System.out.print(input);
            for(int i=1; i<counter;i++){
                System.out.print(input+(2*i));
            }
        }
    }

}
