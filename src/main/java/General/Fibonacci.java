package General;

public class Fibonacci {
    public static void main(String[] args) {
        // 0, 1, 1, 2, 3, 5, 8, 13, 23..........
        int N = 20;
        int a = 0, b = 0, c = 1;
        for (int i = 0; i < N; i++) {
            a = b;
            b = c;
            c = a+b;
            System.out.print(c+" ");
        }
    }
}
