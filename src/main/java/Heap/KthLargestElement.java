package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        while (!pq.isEmpty() && k > 0) {
            res.add(pq.poll());
            k--;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {12, 5, 787, 1, 23};
        int k = 2;
        System.out.println(kLargest(arr, k));
        int[] num = {1, 23, 12, 9, 30, 2, 50};
        int p = 3;
        System.out.print(kLargest(num, p));
    }
}
