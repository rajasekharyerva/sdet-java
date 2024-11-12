package sdet.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SecondHighestHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);
        map.put("D", 25);
        map.put("E", 15);

        ArrayList<Integer> arrayList = new ArrayList<>(map.values());
        Collections.sort(arrayList);

        int secHighest = arrayList.get(arrayList.size() - 2);
        System.out.println(secHighest);

        for(Map.Entry<String, Integer> entrySet: map.entrySet()) {
                if(entrySet.getValue() == secHighest) {
                    map.remove(entrySet.getKey());
                    //break;
                }
        }
        for(Map.Entry<String, Integer> entrySet: map.entrySet()) {
            System.out.println(entrySet.getKey()+entrySet.getValue());
        }


    }
}
