package sdet;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesWithoutSet {
    public static void main(String[] args) {
        Integer [] numbers = {1, 2, 5, 4, 5, 4, 4};
        removeDuplicatesArray(numbers);
    }

    private static void removeDuplicatesArray(Integer[] numbers) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<numbers.length;i++){
            if(!list.contains(numbers[i])) {
                list.add(numbers[i]);
            }
        }
        int[] newArray = new int[list.size()];
        for(int i=0; i<newArray.length;i++){
            newArray[i] = list.get(i);
            System.out.println(newArray[i]);
        }


    }
}
