package Array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySum {
    public static int longestSubarrayWithSum(int[] arr, int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int curr_sum = 0;
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            curr_sum += arr[i];

            if (curr_sum == k) {
                maxLen = i+1;
            }
            // Check if there is a previous subarray we can exclude to get the sum k
            if (sumMap.containsKey(curr_sum - k)) {
                maxLen = Math.max(maxLen, i - sumMap.get(curr_sum - k));
            }
            // Only add current sum to map if it hasn't been seen before
            if (!sumMap.containsKey(curr_sum)) {
                sumMap.put(curr_sum, i);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;
        System.out.println("Length of the longest subarray: " + longestSubarrayWithSum(arr, k));
    }
}
