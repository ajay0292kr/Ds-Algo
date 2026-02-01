package TwoPointers;

public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int curr_sum = 0;
        while (l < r) {
            curr_sum = numbers[l] + numbers[r];
            if (curr_sum == target) {
                return new int []{l+1, r+1};
            }else if (curr_sum > target) {
                r--;
            }else {
                l++;
            }
        }
        return new int []{-1, -1};
    }
    public static void main(String[] args) {
        int []numbers = {2,7,11,15}; int target = 9;
        int[] res = twoSum(numbers, target);
        System.out.print("["+res[0]+" "+res[1]+"]");
    }
}
