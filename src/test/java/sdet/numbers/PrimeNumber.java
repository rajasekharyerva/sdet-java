package sdet.numbers;

public class PrimeNumber {
    public static void main(String[] args){
        int num = 21;
        if(num <=1){
            System.out.println("not a prime number");
        }

        for(int i=2; i*i<=num;i++){
            if(num%i==0){
                System.out.println("not a prime number");
                break;
            }
        }
    }
}
