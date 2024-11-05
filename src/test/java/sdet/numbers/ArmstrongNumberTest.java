package sdet.numbers;

import java.util.Scanner;

public class ArmstrongNumberTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int input = sc.nextInt();
        int actualNum = input;
        double res = 0;
        while(input!=0){
            int m = input%10;
            res = res + Math.pow(m,3);
            input = input/10;
        }

        if (res == actualNum) {
            System.out.println(actualNum + " is an Armstrong number");
        } else {
            System.out.println(actualNum + " is not an Armstrong number");
        }

    }
}
