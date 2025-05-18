package booking;

public class M200NumberOfIslands {

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    count++;
                    findIsland(grid, visited, row, col);
                }
            }
        }
        return count;
    }

    private void findIsland(char[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0' || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        findIsland(grid, visited, row + 1, col);
        findIsland(grid, visited, row - 1, col);
        findIsland(grid, visited, row, col + 1);
        findIsland(grid, visited, row, col - 1);
    }
}
