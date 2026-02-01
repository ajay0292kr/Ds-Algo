package TwoPointers;

public class RemoveDuplicate {
    public static void removeDuplicate(int [] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
    }
    int j = 0;
    int count = 0;
    public int removeDuplicates(int[] nums) {
        for(int i = 0; i < nums.length -1; i++) {
            if (nums[i] == nums[i+1]) {
                count++;
            }
        }

        return count + 1;
    }
}
