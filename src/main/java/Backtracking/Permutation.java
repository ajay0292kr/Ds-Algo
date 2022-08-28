package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {
        // Declare set here becuase we have to return only unique list
        Set<List<Integer>> result;
        public List<List<Integer>> permuteUnique(int[] nums) {
            result = new HashSet<>();
            // String index from 0
            permuteUniqueHelper(nums, 0);
            return new ArrayList<>(result);
        }
        public void permuteUniqueHelper(int []nums, int index) {
            // If the index length is equals to array length that means we found permutation
            if(index == nums.length) {
                List<Integer> currentList = new ArrayList<>();
                for(int i = 0; i<nums.length; i++) {
                    currentList.add(nums[i]);
                }
                result.add(currentList);
                return;
            }else {
                for(int i = index; i<nums.length; i++) {
                    // in first step 123 -> left side child 213 right side child and so on....
                    swap(nums, i, index);
                    permuteUniqueHelper(nums, index+1);
                    // Backtrack the last result - Means again back from left->root and then go right
                    swap(nums, i, index);
                }
            }
        }
        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        Permutation per = new Permutation();
        System.out.print(per.permuteUnique(a));
    }
}
