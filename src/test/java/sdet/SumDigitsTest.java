package sdet;

public class SumDigitsTest {
    public static void main(String[] args){
    int input =635768479;
    int res=0;
    while(input!=0){
        int mod=input%10;
        input=input/10;
        res=res+mod;
    }
        System.out.println(res);
    }
}
