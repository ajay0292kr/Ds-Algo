package Array;

import java.util.HashMap;

public class MaximumSubArrayWithSumZero {
     // Time Complexity: O(N2)
    //Auxiliary Space: O(1)
   /* public static int maxLen(int[] arr, int N) {
        int max_len = 0;
        for(int i = 0; i<N; i++) {
            int curr_sum = 0;
            for(int j = i; j<N; j++) {
                curr_sum+=arr[j];
                if(curr_sum == 0) {
                    max_len = Math.max(max_len, j-i+1);
                }
            }
        }
        return max_len;
    }*/

    // Optimize Solutions

    static int maxLen(int arr[], int n)
    {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM
                = new HashMap<Integer, Integer>();

        int sum = 0; // Initialize sum of elements
        int max_len = 0; // Initialize result

        // Traverse through the given array
        for (int i = 0; i < n; i++) {
            // Add current element to sum
            sum += arr[i];

            if (arr[i] == 0 && max_len == 0)
                max_len = 1;

            if (sum == 0)
                max_len = i + 1;

            // Look this sum in hash table
            Integer prev_i = hM.get(sum);

            // If this sum is seen before, then update
            // max_len if required
            if (prev_i != null)
                max_len = Math.max(max_len, i - prev_i);
            else // Else put this sum in hash table
                hM.put(sum, i);
        }

        return max_len;
    }
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int N = arr.length;

        // Function call
        System.out.println("Length of the longest 0 sum "
                + "subarray is " + maxLen(arr, N));
    }
}
