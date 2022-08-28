package Array;

import java.util.ArrayList;

public class SubArrayWithGivenSum {
    static void subarrayWithGivenSum(int[] arr, int sum) {
        int curr_sum = 0;
        int j = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i<arr.length; i++) {
            curr_sum+=arr[i];
            // when sum  = 0 then simply return -1
            while(curr_sum > sum && sum!=0) {
                curr_sum = curr_sum - arr[j];
                j++;
            }
            if(curr_sum == sum) {
                result.add(j);
                result.add(i);
                System.out.print("Index from " + j + " to " + i);
            }
        }
        if(result.size() <=0 || sum == 0) {
            result.add(-1);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 20, 3, 10, 5};
        int sum = 33;
        subarrayWithGivenSum(arr, sum);
    }
}
