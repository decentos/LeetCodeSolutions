package me.decentos.leetcode.hard;

public class H980UniquePaths3 {
    private static int count = 0;

    public static int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length, steps = 0;
        int startCol = -1, startRow = -1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) steps++;
                if (grid[i][j] == 1) {
                    startCol = i;
                    startRow = j;
                }
            }
        }
        helper(grid, startCol, startRow, steps);
        return helper2(grid, startCol, startRow, steps);
    }

    private static void helper(int[][] grid, int col, int row, int steps) {
        if (col < 0 || row < 0 || col > grid.length - 1 || row > grid[0].length - 1 || grid[col][row] == -1) return;

        if (grid[col][row] == 2) {
            if (steps == -1) count++;
            return;
        }

        grid[col][row] = -1;
        steps--;
        helper(grid, col + 1, row, steps);
        helper(grid, col - 1, row, steps);
        helper(grid, col, row + 1, steps);
        helper(grid, col, row - 1, steps);

        grid[col][row] = 0;
    }

    private static int helper2(int[][] grid, int col, int row, int steps) {
        if (col < 0 || row < 0 || col > grid.length - 1 || row > grid[0].length - 1 || grid[col][row] == -1) return 0;

        if (grid[col][row] == 2) {
            return steps == -1 ? 1 : 0;
        }

        grid[col][row] = -1;
        steps--;
        int totalPaths = helper2(grid, col + 1, row, steps)
                + helper2(grid, col - 1, row, steps)
                + helper2(grid, col, row + 1, steps)
                + helper2(grid, col, row - 1, steps);

        grid[col][row] = 0;
        return totalPaths;
    }
}
