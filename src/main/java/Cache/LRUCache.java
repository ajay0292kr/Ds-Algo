package Cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private int capacity;

    // Stores the key-value
    private Map<Integer, Integer> cacheMap;
    // stores keys in the order of access
    private LinkedList<Integer> lruList;

    // Constructor to initialize the cache with a given capacity
    LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.lruList = new LinkedList<>();
    }

    // Function to get the value for a given key
    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }

        // Move the accessed key to the front of the list
        lruList.remove((Integer) key);
        lruList.addFirst(key);

        return cacheMap.get(key);

    }
    // Function to put a key-value pair into the cache
    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            // Update the value and move the key to the front of the list
            cacheMap.put(key, value);
            lruList.remove((Integer) key);
        }else {
            if (cacheMap.size() >= capacity) {
                // Remove the least recently used item
                int lruKey = lruList.removeLast();
                cacheMap.remove(lruKey);
            }
            cacheMap.put(key, value);
        }

        // Add the new key-value pair to the cache
        lruList.addFirst(key);
    }
}
