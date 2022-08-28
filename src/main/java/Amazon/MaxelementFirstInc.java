package Amazon;

public class MaxelementFirstInc {
    static void maxElement(int[] arr, int n) {
        for(int i = 0; i<n; i++) {
            if(arr[i] > arr[i+1]) {
                System.out.println(arr[i]);
                break;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
        int n = arr.length;
        maxElement(arr, n);
    }
}
