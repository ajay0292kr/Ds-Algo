package SlidingWindows;

public class NumSubArrayWithSum {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int curr_sum = 0;
        int cnt = 0;
        int j = 0;
        int i = 0, k = 0;
        for (i = k; i < nums.length; i++) {
            curr_sum = curr_sum + nums[i];

            if (curr_sum == goal) {
                cnt++;
            }else if (curr_sum > goal) {
                curr_sum = 0;
                j++;
                k = j;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int nums[] = {1,0,1,0,1};
        int goal = 2;
        System.out.print(numSubarraysWithSum(nums, goal));
    }
}
