package dp;

public class M62UniquePaths {

    public static int uniquePaths(int m, int n) {
        return helper(m, n, new int[m + 1][n + 1]);
    }

    private static int helper(int m, int n, int[][] arr) {
        if (m < 1 || n < 1) return 0;
        if (m == 1 && n == 1) return 1;

        if (arr[m][n] != 0) return arr[m][n];
        arr[m][n] = helper(m - 1, n, arr) + helper(m, n - 1, arr);

        return arr[m][n];
    }

    public static int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int col = 1; col < m; col++) {
            dp[col][0] = 1;
        }
        for (int row = 1; row < n; row++) {
            dp[0][row] = 1;
        }

        for (int col = 1; col < m; col++) {
            for (int row = 1; row < n; row++) {
                dp[col][row] = dp[col - 1][row] + dp[col][row - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
