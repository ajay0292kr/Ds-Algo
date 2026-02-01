package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    /*
      Reverse first K of a Queue
     */
    public static Queue<Integer> reverseFirstK(Queue<Integer > q, int k) {
        if (q == null || k <= 0 || k > q.size()) {
            return q;
        }
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push first k elements into stack
        for (int i = 0; i < k; i++) {
            stack.push(q.poll());
        }

        // Step 2: Pop from stack and add back to queue
        while (!stack.isEmpty()) {
            q.offer(stack.pop());
        }

        // Step 3: Move remaining elements to back
        int size = q.size();
        for (int i = 0; i < size - k; i++) {
            q.offer(q.poll());
        }

        return q;
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);

        int k = 3;
        System.out.println("Original Queue: " + q);
        Queue<Integer> result = reverseFirstK(q, k);
        System.out.println("After reversing first " + k + ": " + result);
    }
}
