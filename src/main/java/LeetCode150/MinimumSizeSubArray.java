package LeetCode150;

public class MinimumSizeSubArray {
    public static int minSubArrayLen(int target, int[] nums) {
        int currSum = 0;
        int result = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum+=nums[i];
            while (currSum >= target) {
                result = Math.min(result, i - j+1);
                currSum = currSum - nums[j++];
            }
        }
        if(result==Integer.MAX_VALUE) {
            return 0;
        }else {
            return result;
        }
        //return result;
    }
    public static void main(String[] args) {
        // Minimum Size Subarray Sum
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, nums));
    }
}
