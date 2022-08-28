package Array;

public class LargestSumContinuousSubArray {
    // Kadane Algorithm
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    static void maxSumSubArray(int[] arr, int n) {
        long max = Integer.MIN_VALUE;
        long curr_sum = 0;
        for(int i = 0; i<n; i++) {
            curr_sum +=arr[i];
            if(curr_sum > max) {
                max = curr_sum;
            }
            if(curr_sum < 0) {
                curr_sum = 0;
            }
        }
        System.out.println(max);
    }

    // DP Solutions - > Largest sum continuous when all elements are negative

    public static void maxSumSubArrayDp(int[] arr, int n) {
        long curr_max = arr[0];
        long max_so_far = arr[0];
        for(int i = 1; i<n; i++) {
            curr_max = Math.max(arr[i], curr_max+arr[i]);
            max_so_far = Math.max(curr_max, max_so_far);
        }
        System.out.print(max_so_far);
    }
    public static void main(String[] args) {
        int N = 5;
        int[] arr = {1,2,3,-2,5};
        maxSumSubArray(arr, N);
        maxSumSubArrayDp(arr, N);
    }
}
