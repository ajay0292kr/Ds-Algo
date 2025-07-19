package SlidingWindows;

public class MaxSlidingWindows {
    // 239. Sliding Window Maximum Leetcode
    public static int [] maxSlidingWindows(int nums[], int k) {
        int result[] = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        int t = 0;
        for (int i = 0; i <= nums.length - k; i++ ) {
            int j = i;
            max = Integer.MIN_VALUE;
            while (j < i+k) {
                max = Math.max(max, nums[j]);
                j++;
            }
            result[t++] = max;
        }
        return result;
    }
    public static void main(String[] args) {
        int []nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = maxSlidingWindows(nums, k);
        for(int j: res) {
            System.out.print(j+" ");
        }
    }
}

// Optimize Solution using dqueue

