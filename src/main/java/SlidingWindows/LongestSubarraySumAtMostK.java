package SlidingWindows;

public class LongestSubarraySumAtMostK {
    public static int longestSubarray(int nums[], int k) {
        //  Return the length of the longest subarray whose sum is ≤ k.
        int left = 0, right = 0, sum = 0, maxLength = 0;
        while (right < nums.length) {
            sum +=nums[right];

            while (sum > k) {
                sum -= nums[left];
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 0, 1, 1, 0};
        int k = 4;
        System.out.println("Longest subarray length: " + longestSubarray(arr, k));
    }
}
