package SlidingWindows;

public class MinSubArrayLength {
    /*
      Given an array of positive integers nums and a positive integer target, return the minimal
      length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
     */
    public static int minSubArrayLen(int nums[], int target) {
        int currSum = 0;
        int result = Integer.MAX_VALUE;
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            while (currSum >= target) {
                result = Math.min(result, i -j +1);
                currSum = currSum - nums[j++];
            }
        }
        if (result == Integer.MAX_VALUE) {
            return 0;
        }else {
            return result;
        }
    }
    public static void main(String[] args) {
        int target = 7;
        int []nums = {2,3,1,2,4,3};
        System.out.print(minSubArrayLen(nums, target));
    }
}
