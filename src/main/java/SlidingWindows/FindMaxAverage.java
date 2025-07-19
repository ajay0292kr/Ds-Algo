package SlidingWindows;

public class FindMaxAverage {
    public static double findMaxAverage(int arr[], int k) {
        double currSum = 0;
        for (int i = 0; i < k; i++) {
            currSum += arr[i];
        }
        double max = currSum;
        int j = 0;
        for (int i = k; i < arr.length; i++) {
            currSum += arr[i] - arr[j++];
            max = Math.max(max, currSum);
        }
        return max/k;
    }
    public static void main(String[] args) {
        int []nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.print(findMaxAverage(nums, k));
    }
}
