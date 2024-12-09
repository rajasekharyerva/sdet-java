package sdet.numbers;

public class Denomination {
    public static void main(String[] args) {
        int num=596;
        int[] denominations={500, 200, 100, 50, 20, 10, 5,2,1};
        for(int d: denominations){
            int d1 =num/d;
            if(d1 != 0)
                System.out.println(d +"="+ d1);
            num=num%d;
        }
    }
}
