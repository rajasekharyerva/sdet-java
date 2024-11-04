package sdet.arrays;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicatesInArray {
    public static void main(String[] args) {
        String[] arr = { "java", "python", "C", "C++", "java", "python" };
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    System.out.println("Found duplicate element " + arr[i]);
                }
                //System.out.println("-");
            }
        }
        Map<String, Integer> countMap = new HashMap<>();
        for(String str: arr){
            countMap.put(str, countMap.getOrDefault(str,0)+1);
        }

        for(Map.Entry<String, Integer> entry: countMap.entrySet()){
                if(entry.getValue() > 1) {
                    System.out.println(entry.getKey()+"->"+entry.getValue());
                }
        }
    }
}
