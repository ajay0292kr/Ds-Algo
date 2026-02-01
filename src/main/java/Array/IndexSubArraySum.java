package Array;

import java.util.ArrayList;

public class IndexSubArraySum {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        int curr_sum = 0;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            curr_sum += arr[i];
            if (curr_sum > target) {
                while (curr_sum > target) {
                    curr_sum = curr_sum - arr[j];
                    j++;
                }
            }
            if (curr_sum == target) {
                res.add(j+1);
                res.add(i+1);
                return res;
            }
        }
        res.add(-1);
        return res;
    }
}
