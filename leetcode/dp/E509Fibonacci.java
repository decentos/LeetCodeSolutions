package dp;

public class E509Fibonacci {

    public static int fib(int n) {
        if (n <= 1) return n;

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public int fib2(int n) {
        if (n < 2) return n;

        int prev1 = 0, prev2 = 1, curr = 0;

        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }
        return curr;
    }
}
