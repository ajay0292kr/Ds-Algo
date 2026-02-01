package LeetCode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        if (n < 3) {
            return res;
        }
        for (int i = 0; i < n -2; i++ ) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = n-1;
            while (left < right ) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Skip duplicates for left
                    while (left < right && nums[left] == nums[left+1]) left++;
                    // Skip duplicates for right
                    while (left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // need a bigger sum
                } else {
                    right--; // need a smaller sum
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> threeSum = threeSum(nums);
        System.out.print(threeSum);
    }
}
