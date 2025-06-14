package Array;

public class LeftRightRotation {
    public static int [] rightRotate(int[] arr, int k) {
        // array right rotation
        int n = arr.length;
        int[] tmp = new int [n];
        for (int i= 0; i <n; i++) {
            tmp[(i+k)%n] = arr[i];
        }
        // left rotation logic
       /* for(int i = 0; i < n; i++) {
            tmp[i] = arr[(i+k)%n];
        }*/
        return tmp;
    }
    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 4, 5};
        int k = 3;
        //int arr[]= leftRotate(nums, k);
        int arr[]= rightRotate(nums, k);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
