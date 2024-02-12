package dp;

public class H741CherryPickup {

    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = n * 2 - 1;
        int[][] dp = new int[n][n];
        dp[0][0] = grid[0][0];

        for (int s = 1; s < m; s++) {
            for (int i = n - 1; i >= 0; i--) {
                for (int p = n - 1; p >= 0; p--) {
                    int j = s - i, q = s - p;

                    if (j < 0 || j >= n || q < 0 || q >= n || grid[i][j] == -1 || grid[p][q] == -1) {
                        dp[i][p] = -1;
                        continue;
                    }

                    if (i > 0) {
                        dp[i][p] = Math.max(dp[i][p], dp[i - 1][p]);
                    }

                    if (p > 0) {
                        dp[i][p] = Math.max(dp[i][p], dp[i][p - 1]);
                    }

                    if (i > 0 && p > 0) {
                        dp[i][p] = Math.max(dp[i][p], dp[i - 1][p - 1]);
                    }

                    if (dp[i][p] >= 0) {
                        dp[i][p] += grid[i][j] + (i != p ? grid[p][q] : 0);
                    }
                }
            }
        }
        return Math.max(dp[n - 1][n - 1], 0);
    }
}
