package sdet;

import java.util.HashSet;

public class QC {
    public static void main(String[] args){
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        checkUser(intArray);

    }

    private static String checkUser(int[] intArray) {
        HashSet<Integer> intSet = new HashSet<>();
        int sum=10;
        for(int i:intArray){
            int pair = sum-i;
            if(intSet.contains(pair)){
                System.out.println("{"+pair+","+i+"}");
            }
            intSet.add(i);
        }
        return "";
    }
}
