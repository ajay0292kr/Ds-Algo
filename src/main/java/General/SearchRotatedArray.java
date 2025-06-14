package General;

public class SearchRotatedArray {
    public static int search(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) return mid;

            if (nums[left] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                }else {
                    left = mid+1;
                }
            }else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid+1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2}; // Example rotated array
        int target = 0; // Element to search
        int result = search(nums, target); // Perform search
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
