package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    void push(int a) {
        // code here
        // Step 1: Add new element into q2
        q2.offer(a);

        // Step 2: Move all elements from q1 -> q2
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        // Step 3: Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    int pop() {

        if (q1.isEmpty()) {
            return -1; // stack underflow
        }
        return q1.poll(); // dequeue from q1
    }
}
