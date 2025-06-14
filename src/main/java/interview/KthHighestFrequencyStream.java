package interview;

import java.util.*;
import java.util.stream.Collectors;

public class KthHighestFrequencyStream {
    public static char findKthHighestChar(String stream, int k) throws IllegalAccessException {
        if (stream == null || stream.length() == 0 || k <= 0) {
            throw new IllegalAccessException("Invalid input");
        }
        // Step 1: Count character frequencies
        Map<Character, Integer> map = new HashMap<>();
        for (char c: stream.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // Step 2: Use a min-heap (PriorityQueue) to keep top K
        PriorityQueue<Map.Entry<Character, Integer>> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove the least frequent
            }
        }
        // Step 3: The root of heap is the Kth highest frequency character
        assert minHeap.peek() != null;
        return minHeap.peek().getKey();
    }

    // using java stream API

    public static char findKthHighestChar2(String input, int k) {
        if (input == null || input.isEmpty() || k <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        // Step 1: Count character frequencies using streams
        Map<Character, Long> freqMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        // Step 2: Sort by frequency descending and get Kth element
        return freqMap.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue())) // descending
                .skip(k - 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new NoSuchElementException("Less than K unique characters"));
    }
    public static void main(String[] args) throws IllegalAccessException {
        String stream = "aabcccddddee";
        int k = 2;
        char result = findKthHighestChar(stream, k);
        findKthHighestChar2(stream, k);
        System.out.println("The " + k + "th highest frequency character is: " + result);
    }
}
