package dp;

public class H629KInversePairsArray {

    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    for (int t = 0; t <= Math.min(j, i - 1); t++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - t]) % 1_000_000_007;
                    }
                }
            }
        }
        return dp[n][k];
    }
}
