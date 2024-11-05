package sdet.numbers;

import java.util.Scanner;

public class FactorialTest {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        //factorialRecursive();
        int output =factorialNonRecursive(input);
        System.out.println(output);
    }

    private static int factorialNonRecursive(int input) {
        int output=1;
        for(int i = input; i>1;i--) {
            output = output*i;
        }
        return output;
    }

    private static int factorialRecursive(int input) {
        if(input == 1){
            return 1;
        } else {
            return input * factorialRecursive(input-1);
        }
    }
}
