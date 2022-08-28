package Array;

public class SeperateEvenAndOdd {
    // With extra space
   /* static void arrayEvenAndOdd(int[] arr, int n) {
        int tmp[] = new int [n];
        int j = 0;
        for(int i = 0; i<n; i++) {
            if (arr[i]%2 == 0) {
                tmp[j++] = arr[i];
            }
        }
        for(int i = 0; i<n; i++) {
            if(arr[i]%2!=0) {
                tmp[j++] = arr[i];
            }
        }
        for(int i = 0; i<n; i++) {
            System.out.print(tmp[i]+" ");
        }
    }*/
    // without using extra space
    static void arrayEvenAndOddWithoutExtraSpace(int[] arr, int n) {
        int i = -1, j = 0;
        while (j != n) {
            if (arr[j] % 2 == 0)
            {
                i++;

                // Swapping even and
                // odd numbers
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
        for(int k = 0; k<n; k++) {
            System.out.print(arr[k]+ " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 4, 7, 6, 9, 10 };
        int n = arr.length;

        // Function call
        //arrayEvenAndOdd(arr, n);
        arrayEvenAndOddWithoutExtraSpace(arr, n);
    }
}
