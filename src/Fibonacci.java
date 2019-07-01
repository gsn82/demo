import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(finNaive(5));
        System.out.println(finNaive(10));
        System.out.println(finFibonacci(100));

        long[] mem = new long[100 + 1];
        Arrays.fill(mem, -1);
        System.out.println(finNaive2(100, mem));
    }

    // наивным , медленным, очевидным
    private static long finNaive(int n) {
        if (n <= 1)
            return n;

        return finNaive(n - 1) + finNaive(n - 2);
    }

    private static long finNaive2(int n, long[] mem) {
        if (mem[n] != -1)
            return mem[n];

        if (n <= 1)
            return n;

        mem[n] = finNaive2(n - 2, mem) + finNaive2(n - 1, mem);

        return mem[n];
    }

    private static long finFibonacci(int n) {
        long[] x = new long[n + 1];
        x[0] = 0;
        x[1] = 1;

        for (int i = 2; i <= n; i++) {
            x[i] = x[i - 1] + x[i - 2];
        }

        return x[n];
    }
}
