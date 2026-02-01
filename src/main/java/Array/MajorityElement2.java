package Array;

public class MajorityElement2 {
    public static int majorityElement(int nums[]) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
            System.out.println("num=" + num + " candidate=" + candidate + " count=" + count);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority Element: " + majorityElement(nums));
    }
}
