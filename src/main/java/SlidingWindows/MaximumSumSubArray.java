package SlidingWindows;

public class MaximumSumSubArray {
    // Maximum sum sub-array of size k
    static int maxSumSubArray(int arr[], int n, int k) {
        int i = 0, j = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        if (n < k)
        {
            System.out.println("Invalid");
            return -1;
        }
        while (j <n) {
            sum+=arr[j];
            if(j-i+1 < k) {
                j++;
            }else if (j - i + 1 == k) {
                max = Math.max(sum, max);
                sum = sum - arr[i];
                i++;
                j++;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        int n = arr.length;

        System.out.println(maxSumSubArray(arr, n, k));
    }
}
