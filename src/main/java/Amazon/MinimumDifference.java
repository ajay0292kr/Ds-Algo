package Amazon;

import java.util.Arrays;

public class MinimumDifference {
    // Given an unsorted array, find the minimum difference between any pair in given array.
    static int minDifference(int nums[]) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i<nums.length-1; i++) {
            min = Math.min(min, Math.abs(nums[i]-nums[i+1]));
        }
        return min;
    }
    public static void main(String[] args) {
     int nums[] = {2, 4, 5, 9, 7};
     System.out.println("Min Distance between "+ minDifference(nums));
    }
}
