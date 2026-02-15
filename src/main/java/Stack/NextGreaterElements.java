package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10};
        System.out.println(Arrays.toString(nextGreater(arr)));
    }
    public static int[] nextGreater(int nums[]) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        for (int i = n-1; i >=0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1: stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}
