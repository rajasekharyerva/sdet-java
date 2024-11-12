package sdet.collections;

import java.util.Map;
import java.util.TreeMap;

public class PrintTreeMapElements {
    public static void main(String[] args) {
        // Create a TreeMap
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        // Add elements to the TreeMap
        treeMap.put("Date", 40);
        treeMap.put("Apple", 50);
        treeMap.put("Cherry", 30);
        treeMap.put("Elderberry", 10);
        treeMap.put("Banana", 20);
        // Print all elements in the TreeMap
        System.out.println("TreeMap elements:");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

