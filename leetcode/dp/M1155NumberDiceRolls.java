package dp;

public class M1155NumberDiceRolls {

    public int numRollsToTarget(int n, int k, int target) {
        return backtrack(new Integer[n + 1][target + 1], n, k, target);
    }

    private int backtrack(Integer[][] memo, int n, int k, int target) {
        if (target < 0) {
            return 0;
        } else if (n == 0) {
            return target == 0 ? 1 : 0;
        } else if (memo[n][target] != null) {
            return memo[n][target];
        }

        int count = 0;
        for (int i = 1; i <= k; i++) {
            count = (count + backtrack(memo, n - 1, k, target - i)) % 1_000_000_007;
        }
        memo[n][target] = count;
        return count;
    }

// ===============================================================================

    public int numRollsToTarget_DP(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;

        for (int dice = 1; dice <= n; dice++) {
            for (int t = 0; t <= target; t++) {
                for (int face = 1; face <= k; face++) {
                    if (face <= t) {
                        dp[dice][t] = (dp[dice][t] + dp[dice - 1][t - face]) % 1_000_000_007;
                    }
                }
            }
        }
        return dp[n][target];
    }
}
