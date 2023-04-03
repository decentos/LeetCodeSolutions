package dp;

public class E70ClimbingStairs {

    public int climbStairs(int n) {
        if (n < 3) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public int climbStairs2(int n) {
        if (n < 3) return n;

        int prev1 = 1, prev2 = 2, curr = 0;

        for (int i = 2; i < n; i++) {
            curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }
        return curr;
    }
}
