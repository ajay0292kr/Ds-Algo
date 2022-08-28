package Array;

public class ReplaceTwoConsutive {
    static void replace_elements(int[] arr, int n) {
        int pos = 0;

        for(int i = 0; i<n; i++) {
            arr[pos++] = arr[i];
            while(pos > 1 && arr[pos-2] == arr[pos-1]) {
                pos--;
                arr[pos-1]++;
            }

        }
        for (int i = 0; i < pos; i++)
            System.out.print( arr[i] + " ");
    }
    public static void main(String[] args) {
        int arr[] = { 6, 4, 3, 4, 3, 3, 5 };
        int a[] = {5, 2, 1, 1, 2, 2 };
        int n = arr.length;
        replace_elements(arr, n);
        //replace_elements1(a, n);
    }
}
