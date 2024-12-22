package linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true); // true for access order
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
        if (cache.size() > capacity) {
            // Remove eldest entry when the size exceeds the capacity
            cache.remove(cache.entrySet().iterator().next().getKey());
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1); // cache: {1=1}
        cache.put(2, 2); // cache: {1=1, 2=2}
        System.out.println(cache.get(3)); // returns 1
        cache.put(3, 3); // evicts key 2, cache: {1=1, 3=3}
        System.out.println(cache.get(2)); // returns -1 (not found)
    }
}

