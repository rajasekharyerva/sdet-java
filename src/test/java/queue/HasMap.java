package queue;

import java.util.LinkedList;

class HashMap<K, V> {
    // Bucket array to store chains
    private LinkedList<Entry<K, V>>[] buckets;
    private int capacity; // Default capacity
    private int size;     // Number of key-value pairs in the map

    // Constructor
    public HashMap() {
        this.capacity = 16; // Default initial capacity
        this.buckets = new LinkedList[capacity];
        this.size = 0;
    }

    // Hash function to compute bucket index
    private int getBucketIndex(K key) {
        int hashCode = key == null ? 0 : key.hashCode();
        return Math.abs(hashCode) % capacity;
    }

    // Put key-value pair into the map
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new LinkedList<>();
        }

        // Check if the key already exists
        for (Entry<K, V> entry : buckets[bucketIndex]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing value
                return;
            }
        }

        // Add new entry to the bucket
        buckets[bucketIndex].add(new Entry<>(key, value));
        size++;
    }

    // Get value by key
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];

        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }

        return null; // Key not found
    }

    // Remove key-value pair by key
    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];

        if (bucket != null) {
            bucket.removeIf(entry -> entry.key.equals(key));
            size--;
        }
    }

    // Get size of the HashMap
    public int size() {
        return size;
    }

    // Entry class to represent key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("Value for 'two': " + map.get("two")); // Output: faq2
        map.remove("two");
        System.out.println("Value for 'two' after removal: " + map.get("two")); // Output: null
        System.out.println("Size: " + map.size()); // Output: faq2
    }
}
