package LeetCode150;

public class ArrayMergeSort {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0}; int m = 3;
        int[] nums2 = {2,5,6}; int n = 3;
        merge(nums1,m,nums2,n);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int[] nums3 = new int [m+n];
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                nums3[k++] = nums1[i];
                i++;
            }else {
                nums3[k++] = nums2[j];
                j++;
            }
        }
        while (i < m) {
            nums3[k++] = nums1[i++];
        }
        while(j < n) {
            nums3[k++] = nums2[j++];
        }
        int c = 0;
        for (int v = 0; v < k; v++) {
            nums1[c++] = nums3[v];
        }
    }
}
