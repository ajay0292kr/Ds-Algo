package General;

public class FibonacciRecursive {
    static int nthFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        // Recursive case: sum of the two preceding
       return nthFibonacci(n - 1) + nthFibonacci(n - 2);

    }
    public static void main(String[] args) {
        int N = 5;
        int result = nthFibonacci(N);
        System.out.println(result);
    }
}
