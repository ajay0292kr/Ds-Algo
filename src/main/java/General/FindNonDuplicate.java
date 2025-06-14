package General;

public class FindNonDuplicate {
    public static int nonDuplicate(int[] arr) {
        int res = 0;
        for (int j : arr) {
            res ^= j;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 5, 5};
        System.out.print(nonDuplicate(arr));
    }
}
