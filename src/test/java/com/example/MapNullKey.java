package com.example;

import java.util.HashMap;

public class MapNullKey {
    public static void main(String[] args) {
        HashMap<String, Integer> m = new HashMap<>();
        m.put("A", null);
        m.put("B", 2);
        m.put(null, 3);
        System.out.println(m.get(null));
    }
}
