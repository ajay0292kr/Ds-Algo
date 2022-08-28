package Array;

import java.util.ArrayList;
import java.util.List;

public class SubsetsLeetCode {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i = 0; i<nums.length; i++) {
            int k = result.size();
            for(int j = 0; j<k; j++) {
                List<Integer> tmp = new ArrayList<>(result.get(j));
                tmp.add(nums[i]);
                result.add(tmp);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = subsets(nums);
        System.out.print(result);
    }
}
