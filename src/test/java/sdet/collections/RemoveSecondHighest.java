package sdet.collections;

import java.util.*;

public class RemoveSecondHighest {
    public static void main(String[] args) {
        // Sample HashMap
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 30);
        map.put("C", 20);
        map.put("D", 40);

        System.out.println("Original HashMap: " + map);

        // Remove the second-highest element
        removeSecondHighest(map);

        System.out.println("Updated HashMap: " + map);
    }

    public static void removeSecondHighest(HashMap<String, Integer> map) {
        if (map.size() < 2) {
            System.out.println("Not enough elements to remove second highest.");
            return;
        }

        // Sort the map by values in descending order
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Get the second-highest entry
        Map.Entry<String, Integer> secondHighest = entryList.get(1);

        // Remove the second-highest element
        map.remove(secondHighest.getKey());
    }
}

