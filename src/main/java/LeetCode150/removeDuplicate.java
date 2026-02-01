package LeetCode150;

public class removeDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicate(nums));
    }

    public static int removeDuplicate(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
