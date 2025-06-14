package Collections;

import java.util.LinkedList;

public class CustomHashSet {
    private static final int INITIAL_CAPACITY = 16; // Default size
    private static final double LOAD_FACTOR = 0.75;
    private LinkedList<String>[] buckets; // Array of linked lists
    private int size = 0; // Track number of elements

    @SuppressWarnings("unchecked")
    public CustomHashSet() {
        buckets = new LinkedList[INITIAL_CAPACITY]; // Initialize buckets
    }

    private int getBucketIndex(String key) {
        return (key.hashCode() & 0x7FFFFFFF) % buckets.length; // Ensure non-negative index
    }

    public void add(String key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        if (!buckets[index].contains(key)) { // Avoid duplicates
            buckets[index].add(key);
            size++;
        }
        if (size > buckets.length * LOAD_FACTOR) {
            resize();
        }
    }

    public boolean contains(String key) {
        int index = getBucketIndex(key);
        return buckets[index] != null && buckets[index].contains(key);
    }

    public void remove(String key) {
        int index = getBucketIndex(key);
        if (buckets[index] != null && buckets[index].remove(key)) {
            size--;
        }
    }
    private void resize() {
        LinkedList<String>[] oldBuckets = buckets;
        size = 0;
        buckets = new LinkedList[oldBuckets.length * 2]; // Double capacity
        for (LinkedList<String> bucket : oldBuckets) {
            if (bucket != null) {
                for (String key : bucket) {
                    add(key); // Rehash elements
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
                System.out.println("Bucket " + i + ": " + buckets[i]);
            }
        }
    }

    public static void main(String[] args) {
        CustomHashSet set = new CustomHashSet();
        set.add("Hello");
        set.add("World");
        set.add("Java");
        set.add("Hello"); // Duplicate, should not be added

        System.out.println(set.contains("Java")); // true
        System.out.println(set.contains("Python")); // false

        set.remove("World");
        System.out.println(set.contains("World")); // false

        set.display();
    }
}
