package sdet.numbers;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciTestRecursive {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int fibLen = sc.nextInt();
        int[] fibArr = new int[fibLen];

        //System.out.println(fibonacciRecursive(fibLen));
        fibonacciNonRecursive(fibArr);

    }

    private static void fibonacciNonRecursive(int[] fibArr) {
        fibArr[0]=0;
        fibArr[1]=1;
        for(int i=2;i<fibArr.length;i++){
            fibArr[i]=fibArr[i-1]+fibArr[i-2];
        }
        System.out.println(Arrays.toString(fibArr));
    }

    private static int fibonacciRecursive(int n) {
        if(n<=1){
            return n;
        }
            return fibonacciRecursive(n-1)+fibonacciRecursive(n-2);
    }


}
