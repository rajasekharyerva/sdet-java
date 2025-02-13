package arrays.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySort {
    public static void main(String[] args) {
        //List list = new ArrayList();
        Integer [] arr = {2, 4, 1, 5, 3, 6};
        Arrays.sort(arr, (a,b)->b-a);

        for(int i: arr){
            System.out.println(i);
        }
    }
}
