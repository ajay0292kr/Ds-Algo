package Array;

import java.util.Iterator;
import java.util.PriorityQueue;

public class FirstKElement {
    // Time Complexity: O(nlogn)
    // Auxiliary Space: O(n)
    static void firstKelements(int[] arr, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<k; i++) {
            pq.add(arr[i]);
        }
        for(int i = k; i<n; i++) {
            if(pq.peek() > arr[i]) {
                continue;
            }else {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        Iterator<Integer> itr = pq.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next()+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = { 11, 3, 2, 1, 15, 5, 4,
                45, 88, 96, 50, 45 };

        int size = arr.length;

        // Size of Min Heap
        int k = 3;

        firstKelements(arr, size, k);
    }
}
