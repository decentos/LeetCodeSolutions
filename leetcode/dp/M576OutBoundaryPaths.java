package dp;

import java.util.Arrays;

public class M576OutBoundaryPaths {
    private static final int MOD = 1_000_000_007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] memo = new int[m][n][maxMove + 1];
        for (int[][] row : memo) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        return findPaths(m, n, maxMove, startRow, startColumn, memo);
    }

    private int findPaths(int m, int n, int move, int row, int col, int[][][] memo) {
        if (move < 0) {
            return 0;
        } else if (row < 0 || row >= m || col < 0 || col >= n) {
            return 1;
        } else if (memo[row][col][move] >= 0) {
            return memo[row][col][move];
        }
        int down = findPaths(m, n, move - 1, row + 1, col, memo);
        int up = findPaths(m, n, move - 1, row - 1, col, memo);
        int left = findPaths(m, n, move - 1, row, col - 1, memo);
        int right = findPaths(m, n, move - 1, row, col + 1, memo);
        memo[row][col][move] = ((down + up) % MOD + (left + right) % MOD) % MOD;
        return memo[row][col][move];
    }
}
