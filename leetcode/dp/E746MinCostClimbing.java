package dp;

public class E746MinCostClimbing {

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public int minCostClimbingStairs2(int[] cost) {
        int prev1 = cost[0], prev2 = cost[1], curr = 0;

        for (int i = 2; i < cost.length; i++) {
            curr = Math.min(prev1, prev2) + cost[i];
            prev1 = prev2;
            prev2 = curr;
        }
        return Math.min(prev1, prev2);
    }
}
