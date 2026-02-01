package LeetCode150;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Ensure k is within bounds

        int[] temp = new int[n];

        // Copy the elements to the temporary array in a rotated manner
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }

        // Copy the temporary array back to the original array
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
       // System.out.print(rotate(nums, k));
    }
}
