package Heap;

import java.util.PriorityQueue;

/*
   Given an array arr[] of positive integers and a number k. The task is to find the kth smallest element in the array.
 */
public class KthSmallestElement {
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        while (!pq.isEmpty()) {
            if (k == 1) {
                return pq.poll();
            }
            pq.poll();
            k--;
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {3, 5, 4, 2, 9};
        int k = 3;
        System.out.println("Kth Smallest ele: -> "+ kthSmallest(arr, k));
    }
}
