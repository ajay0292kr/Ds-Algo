package LeetCode150;

public class JumpGame2 {
    public int jump(int[] nums) {
        int jumps = 0;         // number of jumps taken
        int currentEnd = 0;    // farthest index reachable with current number of jumps
        int farthest = 0;      // farthest index reachable with one more jump

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);  // best we can do from index i

            // if we reached the end of the current range
            if (i == currentEnd) {
                jumps++;              // take a jump
                currentEnd = farthest; // extend range
            }
        }

        return jumps;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        JumpGame2 jumpGame2 = new JumpGame2();
        System.out.println(jumpGame2.jump(nums));
    }
}
