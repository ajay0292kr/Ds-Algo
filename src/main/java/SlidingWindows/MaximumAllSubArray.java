package SlidingWindows;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaximumAllSubArray {
    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove indices out of window
            while (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.poll();
            }

            // Remove smaller elements in k range as they are useless
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // Add current element at the back of the deque
            deque.offer(i);

            // Add to result once we have at least k elements
            if (i >= k - 1) {
                if (!deque.isEmpty()) {
                    result.add(nums[deque.peek()]);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        List<Integer> result = maxSlidingWindow(nums, k);
        System.out.println(result); // Output: [3, 3, 5, 5, 6, 7]
    }
}
