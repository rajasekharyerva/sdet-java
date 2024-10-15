package sdet;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciTest {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int fibLen = sc.nextInt();
        int[] fibArr = new int[fibLen];
        fibArr[0]=0;
        fibArr[1]=1;
        for(int i=2;i<fibLen;i++){
            fibArr[i]=fibArr[i-1]+fibArr[i-2];
        }

        System.out.println(Arrays.toString(fibArr));
    }
}
