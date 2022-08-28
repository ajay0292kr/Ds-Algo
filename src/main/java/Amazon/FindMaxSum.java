package Amazon;

public class FindMaxSum {
    // Dynamic Programming approach
    // Step 1 Create an extra space dp, DP array to store the sub-problems.
    // Step 2 Tackle some basic cases, if the length of the array is 0, print 0, if the length of the array is 1,
    // print the first element, if the length of the array is 2, print maximum of two elements.
    // Step 3 Update dp[0] as array[0] and dp[1] as maximum of array[0] and array[1]
    // Step 4 Traverse the array from the second element (2nd index) to the end of array.
    // Step 5 For every index, update dp[i] as maximum of dp[i-2] + array[i] and dp[i-1], this step defines the two cases,
    // if an element is selected then the previous element cannot be selected and if an element is not selected then
    // the previous element can be selected.
    // Step 6 Print the value dp[n-1]
    static int findMaximumSum(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i< n; i++) {
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
     int[] nums = {5,5,10,100,10,5};
     System.out.println("Sum="+findMaximumSum(nums));
    }
}
