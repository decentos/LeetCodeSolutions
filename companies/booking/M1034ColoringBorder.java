package booking;

public class M1034ColoringBorder {

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid, row, col, grid[row][col], color, new boolean[grid.length][grid[0].length]);
        return grid;
    }

    private void dfs(int[][] grid, int row, int col, int initColor, int color, boolean[][] visited) {
        if (!isValid(grid, row, col, initColor, visited)) {
            return;
        }

        visited[row][col] = true;
        boolean isBorder = false;
        if (isBorder(grid, row, col, initColor)) {
            isBorder = true;
        }

        dfs(grid, row + 1, col, initColor, color, visited);
        dfs(grid, row - 1, col, initColor, color, visited);
        dfs(grid, row, col + 1, initColor, color, visited);
        dfs(grid, row, col - 1, initColor, color, visited);

        if (isBorder) {
            grid[row][col] = color;
        }
    }

    private boolean isValid(int[][] grid, int row, int col, int initColor, boolean[][] visited) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == initColor && !visited[row][col];
    }

    private boolean isBorder(int[][] grid, int row, int col, int initColor) {
        return row == 0 || row == grid.length - 1
                || col == 0 || col == grid[0].length - 1
                || grid[row + 1][col] != initColor || grid[row - 1][col] != initColor
                || grid[row][col - 1] != initColor || grid[row][col + 1] != initColor;
    }
}
