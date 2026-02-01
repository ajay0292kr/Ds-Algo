package Heap;

import java.util.PriorityQueue;

public class MinCostRopes {
    /*
      Given an array, arr[] of rope lengths, connect all ropes into a single rope with the minimum total cost.
      The cost to connect two ropes is the sum of their lengths.
     */
    public static int minCost(int [] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int rope: arr) {
            pq.add(rope);
        }
        int totalCost = 0;
        while (!pq.isEmpty() && pq.size() > 1) {
            int first = pq.poll();   // smallest
            int second = pq.poll();  // second smallest
            int cost = first + second;
            totalCost += cost;
            pq.add(cost);  // push the new rope back
        }
        return totalCost;
    }
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};
        System.out.println(minCost(arr));
    }
}
