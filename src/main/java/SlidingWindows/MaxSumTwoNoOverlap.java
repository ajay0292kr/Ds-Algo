package SlidingWindows;

public class MaxSumTwoNoOverlap {
    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(maxSum(nums, firstLen, secondLen), maxSum(nums, secondLen, firstLen));
    }

    private static int maxSum(int[] nums, int L, int M) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int maxL = 0, res = 0;

        for (int i = L + M; i <=n; i++) {
            int lSum = prefix[i-M] - prefix[i - M - L];
            maxL = Math.max(maxL, lSum);
            int mSum = prefix[i] - prefix[i - M];
            res = Math.max(res, maxL + mSum);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,6,5,2,2,5,1,9,4};
        int firstLen = 1, secondLen = 2;
        maxSumTwoNoOverlap(nums, firstLen, secondLen);
        System.out.println(maxSumTwoNoOverlap(nums, firstLen, secondLen));
    }
}
