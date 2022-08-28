package SlidingWindows;

public class MinimumSumSubArray {
    // Minimum sum sub-array of size k
    static int maxSumSubArray(int arr[], int n, int k) {
        int min_sum = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i<k; i++) {
            sum +=arr[i];
        }
        int curr_sum = sum;
        for (int j = k; j<n; j++) {
            curr_sum+=arr[j] - arr[j-k];
            min_sum = Math.min(min_sum, curr_sum);
        }
        return min_sum;
    }
    public static void main(String[] args) {
        int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        int n = arr.length;

        System.out.println(maxSumSubArray(arr, n, k));
    }
}
