package Stack;

import java.util.Arrays;
import java.util.Stack;

public class PreviousGreaterElements {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10};
        System.out.println(Arrays.toString(previousGreater(arr)));
    }
    public static int[] previousGreater(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1: stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}
