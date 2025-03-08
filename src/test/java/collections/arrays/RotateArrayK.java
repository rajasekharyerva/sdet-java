package collections.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArrayK {
    public static void main(String[] args) {
        /*
        Rotate right shift array at 3 times using Java Program.
        Input: [1,faq2,3,4,5,6 ,7] and n=3;
        Output: [5,6,7,1,faq2,3,4]
        */
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        int n = 3;
        n = n % arrayList.size();
        /*List<Integer> resultList = arrayList.subList(arrayList.size() - n, arrayList.size());
        resultList.addAll(arrayList.subList(0, arrayList.size() - n));
        */
        List<Integer> result = new ArrayList<>(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            //swap
            result.add(i, arrayList.get((i + n + 1) % arrayList.size()));
        }
        for (int item : result) {
            System.out.print(item);
        }
    }
}
