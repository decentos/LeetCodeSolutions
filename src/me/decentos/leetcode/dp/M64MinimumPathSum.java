package me.decentos.leetcode.dp;

public class M64MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int col = 1; col < m; col++) {
            grid[col][0] += grid[col - 1][0];
        }
        for (int row = 1; row < n; row++) {
            grid[0][row] += grid[0][row - 1];
        }

        for (int col = 1; col < m; col++) {
            for (int row = 1; row < n; row++) {
                grid[col][row] += Math.min(grid[col - 1][row], grid[col][row - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
