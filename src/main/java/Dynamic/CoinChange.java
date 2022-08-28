package Dynamic;

public class CoinChange {
    public static int count(int arr[], int m, int n) {
        if(n == 0) return 1;
        if(n < 0) return 0;
        // If there are no coins and n
        // is greater than 0, then no
        // solution exist
        if (m <= 0 && n >= 1)
            return 0;

        return count(arr, m-1, n) + count(arr, m, n-arr[m-1]);

    }
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        int m = arr.length;

        System.out.println(count(arr, m, 4));
    }
}
