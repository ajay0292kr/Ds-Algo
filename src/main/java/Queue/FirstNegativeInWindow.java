package Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeInWindow {
    public static List<Integer> firstNegativeInWindow(int[] arr, int k) {
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // Add current element index if it’s negative
            if (arr[i] < 0) {
                q.add(i);
            }

            // Remove elements out of current window
            if (!q.isEmpty() && q.peek() <= i - k) {
                q.poll();
            }

            // Once window size is at least k
            if (i >= k - 1) {
                if (!q.isEmpty()) {
                    result.add(arr[q.peek()]); // first negative
                } else {
                    result.add(0); // no negative
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-8, 2, 3, -6, 10};
        int k = 2;
        System.out.println(firstNegativeInWindow(arr, k)); // [-8, 0, -6, -6]
    }
}
