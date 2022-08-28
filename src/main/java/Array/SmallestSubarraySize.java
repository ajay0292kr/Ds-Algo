package Array;

public class SmallestSubarraySize {
    // Brute Force approach
    // Time Complexity = O(n*n)
    // Space Complexity = O(1)
    public static int subarraySize(int arr[], int n, int x) {
        int min = Integer.MAX_VALUE;
        int curr_sum = 0;
        for(int i = 0; i<n; i++) {
            curr_sum = arr[i];
            if(curr_sum > x) {
                min = Math.min(min, 1);
            }
            for(int j = i+1; j<n; j++) {
                curr_sum += arr[j];
                if (curr_sum > x) {
                    min = Math.min(min, j - i + 1);
                }
            }
        }
        return min;
    }
    // Another approach
    // Sliding windows approach
    public static int subarraySizeSlidingWindows(int[] arr, int n, int x) {
        int min = Integer.MAX_VALUE;
        int curr_sum = 0;
        int j = 0;
        for(int i = 0; i<n; i++) {
            curr_sum+=arr[i];
            while (curr_sum > x) {
                min = Math.min(min, i-j);
                curr_sum = curr_sum - arr[j];
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int arr[] = {1, 10, 5, 2, 7};
        int x  =  9;
        int n = arr.length;
        int min = subarraySize(arr, n, x);
        if(min == Integer.MAX_VALUE) {
            System.out.print("Not Possible");
        }else {
            System.out.println(min);
        }

    }
}
