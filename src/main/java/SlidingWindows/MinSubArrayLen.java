package SlidingWindows;

public class MinSubArrayLen {
    public static int minSubArrayLen(int target, int[] nums) {
        // Minimum Size Subarray Sum
        int n = nums.length;
        int left = 0, sum = 0, minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum +=nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0: minLen;
    }
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int result = minSubArrayLen(target, nums);
        System.out.println("Minimum subarray length: " + result); // Output: 2
    }
}
