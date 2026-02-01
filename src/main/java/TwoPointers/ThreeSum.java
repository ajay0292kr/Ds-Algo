package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int nums[]) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if ( i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = nums.length - 1;
            while ( j < k) {
                if (k < nums.length - 1 && nums[k] == nums[k+1]) {
                    k--;
                    continue;
                }
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    result.add(l);
                    j++;
                    k--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int []nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSum(nums);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }
}
