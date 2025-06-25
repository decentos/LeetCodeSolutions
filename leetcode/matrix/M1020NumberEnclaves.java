package matrix;

public class M1020NumberEnclaves {

    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int row = 0; row < m; row++) {
            if (grid[row][0] == 1) {
                isNotEnclave(grid, row, 0, visited);
            }
            if (grid[row][n - 1] == 1) {
                isNotEnclave(grid, row, n - 1, visited);
            }
        }

        for (int col = 0; col < n; col++) {
            if (grid[0][col] == 1) {
                isNotEnclave(grid, 0, col, visited);
            }
            if (grid[m - 1][col] == 1) {
                isNotEnclave(grid, m - 1, col, visited);
            }
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1 && !visited[row][col]) {
                    count++;
                }
            }
        }

        return count;
    }

    private void isNotEnclave(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] == 0 || visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        isNotEnclave(grid, row + 1, col, visited);
        isNotEnclave(grid, row - 1, col, visited);
        isNotEnclave(grid, row, col + 1, visited);
        isNotEnclave(grid, row, col - 1, visited);
    }
}
