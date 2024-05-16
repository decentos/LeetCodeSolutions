package backtracking;

public class M1219PathMaxGold {

    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int max = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] != 0) {
                    int curr = backtrack(grid, row, col, new boolean[m][n], 0);
                    max = Math.max(max, curr);
                }
            }
        }
        return max;
    }

    private int backtrack(int[][] grid, int row, int col, boolean[][] visited, int sum) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == 0) {
            return sum;
        }

        visited[row][col] = true;
        sum += grid[row][col];

        int up = backtrack(grid, row - 1, col, visited, sum);
        int down = backtrack(grid, row + 1, col, visited, sum);
        int left = backtrack(grid, row, col - 1, visited, sum);
        int right = backtrack(grid, row, col + 1, visited, sum);

        visited[row][col] = false;

        return Math.max(Math.max(up, down), Math.max(left, right));
    }
}
