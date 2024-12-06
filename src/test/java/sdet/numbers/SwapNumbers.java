package sdet.numbers;

public class SwapNumbers {
    public static void main(String[] args) {
        int n1 = 3;
        int n2 =5;
        swapNumbers(n1, n2);
        System.out.println(factorialNumber(n2));
    }

    private static int factorialNumber(int n) {
        if(n==1){
            return 1;
        }
        return n*factorialNumber(n-1);
    }

    private static void swapNumbers(int n1, int n2) {
        n1=n1+n2;//n1+n2
        n2=n1-n2;//n1+n2-n2--->n1
        n1=n1-n2;//n1+n2-n1---->n2
        System.out.println(n1);
        System.out.println(n2);
    }


}
