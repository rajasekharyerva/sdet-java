package sdet.collections.maps;

import java.util.HashMap;
import java.util.Map;

public class Average {
    public static void main(String[] args) {
        Map<String, Integer> users = new HashMap<>();
        /*
        Brian – 21
        Lee – 22
        Cathe – 45
        */

        users.put("Brian", 21);
        users.put("Lee", 22);
        users.put("Cathe", 45);
        int size = users.size();
        int total = 0;
        for (Map.Entry<String, Integer> user : users.entrySet()) {
            total += user.getValue();
        }
        int average = total / size;
        System.out.println(average);
    }
}
