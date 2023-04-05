package dp;

public class M221MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;

        for (int row = m - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                if (matrix[row][col] == '1') {
                    int down = dp[row + 1][col];
                    int right = dp[row][col + 1];
                    int diagonal = dp[row + 1][col + 1];
                    dp[row][col] = Math.min(down, Math.min(right, diagonal)) + 1;
                    max = Math.max(max, dp[row][col]);
                }
            }
        }
        return max * max;
    }
}
