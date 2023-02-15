package matrix;

public class M200NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    helper(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void helper(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') return;
        grid[row][col] = '0';
        helper(grid, row + 1, col);
        helper(grid, row - 1, col);
        helper(grid, row, col + 1);
        helper(grid, row, col - 1);
    }
}
