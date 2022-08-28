package Array;

import java.util.HashMap;

public class SubArraySum {
    /*
      //Brute Force approach
      public static int findSubarraySum(int arr[], int n, int sum) {
        // Time Complexity: O(n)
        // Auxiliary Space: O(n)
        int res = 0;
        for(int i = 0; i<n; i++) {
           int curr_sum = 0;
           for(int j = i; j<n; j++) {
              curr_sum+=arr[j];
           }
           if(curr_sum == sum) res++;
        }
        return res;
    }
     */
    public static int findSubarraySum(int arr[], int n, int sum) {
        // Time Complexity: O(n)
        // Auxiliary Space: O(n)
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int res = 0;
        sumMap.put(0,1);
        int curr_sum = 0;
        for(int i =0; i<n; i++) {
            curr_sum+=arr[i];

            int prev_sum = curr_sum - sum;
            if(sumMap.containsKey(prev_sum)) {
                res+=sumMap.get(prev_sum);
            }
            sumMap.put(curr_sum, sumMap.getOrDefault(curr_sum,0)+1);
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[] = { 10, 2, -2, -20, 10 };
        int sum = -10;
        int n = arr.length;
        System.out.println(findSubarraySum(arr, n, sum));
    }
}
