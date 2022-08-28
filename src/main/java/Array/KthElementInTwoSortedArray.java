package Array;

import java.util.PriorityQueue;

public class KthElementInTwoSortedArray {
    //Input : Array 1 - 2 3 6 7 9
    //        Array 2 - 1 4 8 10
    //        k = 5
    //       Output : 6
    // We are using merging technique here for merge these two array
    static void mergeAndFindKthElement(int[] arr1, int[] arr2, int n1, int n2, int k) {
        int i = 0, j = 0;
        int[] arr3 = new int[n1+n2];
        int l = 0;
        while(i < n1 && j < n2) {
            if(arr1[i] <= arr2[j]) {
                arr3[l++] = arr1[i++];
            }else {
                arr3[l++] = arr2[j++];
            }
        }
        while(i < n1) {
            arr3[l++] = arr1[i++];
        }
        while (j < n2) {
            arr3[l++] = arr1[j++];
        }
        System.out.println(arr3[k]);
    }

    // Using priority Queue
    static void priorityQueue(int[] arr1, int[] arr2, int n1, int n2, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i< n1; i++) {
            pq.offer(arr1[i]);
        }
        for(int j = 0; j< n2; j++) {
            pq.offer(arr2[j]);
        }
        while(k-- > 1) {
            pq.remove();
        }
        System.out.println(pq.peek());
    }
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        int n1 = arr1.length;
        int n2 = arr2.length;
        int k = 5;
        mergeAndFindKthElement(arr1, arr2, n1, n2, k);
        priorityQueue(arr1, arr2, n1, n2, k);
    }
}
