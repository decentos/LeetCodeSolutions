package dp;

public class E70ClimbingStairs {

    public static int climbStairs(int n) {
        return helper(n, new int[n + 1]);
    }

    private static int helper(int n, int[] arr) {
        if (n == 0 || n == 1 || n == 2) return n;
        arr[0] = 1;
        arr[1] = 2;

        if (arr[n] != 0) return arr[n];
        arr[n] = helper(n - 1, arr) + helper(n - 2, arr);
        return arr[n];
    }

    public static int climbStairs2(int n) {
        if (n == 0 || n == 1 || n == 2) return n;

        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }

    public int climbStairs3(int n) {
        int prev1 = 0, prev2 = 1, curr = 0;

        for (int i = n; i > 0; i--) {
            curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }
        return curr;
    }

    public int climbStairs4(int n) {
        if (n < 3) return n;
        int prev1 = 1, prev2 = 2, curr = 0;

        for (int i = 3; i <= n; i++) {
            curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }
        return curr;
    }
}
