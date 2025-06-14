package General;

public class PrimeNumber {
    public static void primeNumber(int N) {
        for (int i = 2; i <=N; i++) {
            if (i%2 != 0 || i == 2) {
                System.out.print(i+" ");
            }
        }
    }
    public static void main(String[] args) {
        int N = 20;
        primeNumber(N);
    }
}
