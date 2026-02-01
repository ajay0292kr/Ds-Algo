package LeetCode150;

public class RemoveDuplicate2 {
    public static int removeDuplicates(int[] nums) {
        int j = 0;
        int cnt = 0;
        int tmp = nums[0];
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == tmp) {
                cnt++;
            }else {
                tmp = nums[i];
                cnt = 1;
            }
            if (cnt <=2) {
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.print(removeDuplicates(nums));
    }
}
