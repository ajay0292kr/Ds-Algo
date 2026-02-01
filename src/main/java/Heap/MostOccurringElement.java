package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/*
  Given an array arr[] in which elements may be repeating several times. Also, a positive number k
  is given and the task is to find sum of total frequencies of k most occurring elements.
 */
public class MostOccurringElement {
    public static int sumOfTopKFrequent(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += Objects.requireNonNull(pq.poll()).getValue();
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 4, 1, 1, 6, 1};
        int k = 2;

        System.out.println(sumOfTopKFrequent(arr, k));
    }
}
