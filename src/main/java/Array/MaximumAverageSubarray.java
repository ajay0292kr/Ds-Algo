package Array;

public class MaximumAverageSubarray {
    public static int maximumArraySub(int[] arr, int n, int k) {
        int max = Integer.MIN_VALUE;
        int current_sum = 0;
        int avg = 0;
        int j = 0;
        int index = 0;
        int last = 0;
        for (int i = 0; i < k; i++) {
            current_sum+=arr[i];
        }
        avg = current_sum/k;
        max = Math.max(max, avg);
        for(int i = k; i<n; i++) {
            current_sum+=arr[i];
            current_sum = current_sum - arr[j];
            avg = current_sum/k;
            if(max < avg) {
                max = Math.max(max, avg);
                index = i;
            }
            last = i;
        }
        System.out.println("Starting Index = "+(index-k+1)+ " ending index = "+index);
        return max;
    }
    public static void main(String[] args) {
        int arr[] = {1, 12, -5, -6, 50, 3};
        int n = arr.length;
        int k = 4;
        int maxAvg = maximumArraySub(arr, n, k);
        System.out.println(maxAvg);
    }
}
