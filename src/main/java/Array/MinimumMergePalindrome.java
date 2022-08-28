package Array;

public class MinimumMergePalindrome {
    /*
       Time Complexity: O(n)
       Auxiliary Space: O(1)
     */
    public static int minimumMerge(int[] arr, int n) {
        int ans = 0;
        int l = 0;
        int r = n-1;
        while(l < r) {
            if(arr[l] ==arr[r]) {
                l++;
                r--;
            }
            // If left element is greater, then
            // we merge right two elements
            else if (arr[l] > arr[r])
            {
                // need to merge from tail.
                r--;
                arr[r] += arr[r+1] ;
                ans++;
            }

            // Else we merge left two elements
            else
            {
                l++;
                arr[l] += arr[l-1];
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {11, 14, 15, 99};
        int n = arr.length;
        int min = minimumMerge(arr, n);
        System.out.println(min);
    }
}
