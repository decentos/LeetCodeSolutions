package dp;

public class H887SuperEggDrop {

    public int superEggDrop(int k, int n) {
        int moves = 0;
        int[][] dp = new int[n + 1][k + 1];

        while (dp[moves][k] < n) {
            moves++;
            for (int i = 1; i <= k; i++) {
                dp[moves][i] = 1 + dp[moves - 1][i] + dp[moves - 1][i - 1];
            }
        }
        return moves;
    }

    public int superEggDrop2(int k, int n) {
        int moves = 0;
        int[] dp = new int[k + 1];

        while (dp[k] < n) {
            moves++;
            for (int i = k; i > 0; i--) {
                dp[i] += dp[i - 1] + 1;
            }
        }
        return moves;
    }
}
