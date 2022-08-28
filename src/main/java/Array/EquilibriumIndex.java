package Array;

public class EquilibriumIndex {
    static int equilibriumIndex(int []arr, int n) {
        // Brute force approach
       /* int left_sum;
        int right_sum;
        int i, j;
        for(i = 0; i<n; i++) {
            left_sum = 0;
            for(j = 0; j < i; j++) {
                left_sum+=arr[j];
            }
            right_sum = 0;
            for(j = i+1; j<n; j++) {
                right_sum+=arr[j];
            }
            if(left_sum == right_sum) {
              return i;
            }
        }*/

        // Doing optimize ways
        int sum = 0; // initialize sum of whole array
        int leftsum = 0; // initialize leftsum

        /* Find sum of the whole array */
        for (int i = 0; i < n; ++i)
            sum += arr[i];

        for (int i = 0; i < n; ++i) {
            sum -= arr[i]; // sum is now right sum for index i

            if (leftsum == sum)
                return i;

            leftsum += arr[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
        int arr_size = arr.length;
        System.out.println(equilibriumIndex(arr, arr_size));
    }
}
