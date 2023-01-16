package me.decentos.leetcode.medium;

public class M200NumberOfIslands {
    static private int n;
    static private int m;

    public static int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    checkNext(grid, i, j);
                    count++;
                }
        }
        return count;
    }

    private static void checkNext(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '2';
        checkNext(grid, i + 1, j);
        checkNext(grid, i - 1, j);
        checkNext(grid, i, j + 1);
        checkNext(grid, i, j - 1);
    }
}
