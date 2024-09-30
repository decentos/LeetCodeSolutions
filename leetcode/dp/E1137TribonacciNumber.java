package dp;

public class E1137TribonacciNumber {

    public int tribonacci(int n) {
        int t0 = 0, t1 = 1, t2 = 1;

        if (n == 0) {
            return t0;
        } else if (n <= 2) {
            return t2;
        }

        for (int i = 3; i <= n; i++) {
            int next = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = next;
        }
        return t2;
    }
}
