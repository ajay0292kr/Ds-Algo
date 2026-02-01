package LeetCode150;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReach = 0;                      // 1
        for (int i = 0; i < nums.length; i++) { // 2
            if (i > maxReach) return false;    // 3
            maxReach = Math.max(maxReach, i + nums[i]); // 4
        }
        return true;                           // 5
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(nums));
    }
}
