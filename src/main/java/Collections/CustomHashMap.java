package Collections;

import java.util.LinkedList;

public class CustomHashMap {
    private static final int INITIAL_CAPACITY = 16;  // Default size
    private static final double LOAD_FACTOR = 0.75;  // Load factor threshold
    private LinkedList<Entry<String, Integer>>[] buckets;  // Array of linked lists
    private int size = 0; // Track number of key-value pairs

    // Inner class for key-value pairs
    static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new LinkedList[INITIAL_CAPACITY]; // Initialize buckets
    }

    private int getBucketIndex(String key) {
        return (key.hashCode() & 0x7FFFFFFF) % buckets.length; // Ensure non-negative index
    }

    public void put(String key, Integer value) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        for (Entry<String, Integer> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update value if key already exists
                return;
            }
        }
        buckets[index].add(new Entry<>(key, value));
        size++;

        if (size > buckets.length * LOAD_FACTOR) {
            resize();
        }
    }

    public Integer get(String key) {
        int index = getBucketIndex(key);
        if (buckets[index] != null) {
            for (Entry<String, Integer> entry : buckets[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null; // Key not found
    }

    public void remove(String key) {
        int index = getBucketIndex(key);
        if (buckets[index] != null) {
            buckets[index].removeIf(entry -> entry.key.equals(key));
            size--;
        }
    }

    private void resize() {
        LinkedList<Entry<String, Integer>>[] oldBuckets = buckets;
        size = 0;
        buckets = new LinkedList[oldBuckets.length * 2]; // Double the capacity
        for (LinkedList<Entry<String, Integer>> bucket : oldBuckets) {
            if (bucket != null) {
                for (Entry<String, Integer> entry : bucket) {
                    put(entry.key, entry.value); // Rehash elements
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public void display() {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                System.out.print("Bucket " + i + ": ");
                for (Entry<String, Integer> entry : buckets[i]) {
                    System.out.print("[" + entry.key + " -> " + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);

        System.out.println("Get 'Three': " + map.get("Three")); // 3
        System.out.println("Get 'Five': " + map.get("Five")); // null

        map.remove("Two");
        System.out.println("Get 'Two' after removal: " + map.get("Two")); // null

        map.display();
    }
}
