package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
  Given k sorted arrays arranged in the form of a matrix arr[] of size k * k. The task is to merge them into one sorted array.
  Return the merged sorted array
 */
public class MergeKSortedArray {
    static class Node {
        int value, row, col;
        Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }
    public static List<Integer> mergeKSortedArrays(int[][] arr, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        List<Integer> result = new ArrayList<>();
        // Step 1: Put the first element of each row in heap
        for (int i = 0; i < k; i++) {
            minHeap.add(new Node(arr[i][0], i, 0));
        }
        // Step 2: Extract min and add next element from same row
        while (!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            result.add(curr.value);

            int nextCol = curr.col + 1;
            if (nextCol < k) {
                minHeap.add(new Node(arr[curr.row][nextCol], curr.row, nextCol));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int k = 3;
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result = mergeKSortedArrays(arr, k);
        System.out.println(result);
    }
}
