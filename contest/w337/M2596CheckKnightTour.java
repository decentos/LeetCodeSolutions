package w337;

public class M2596CheckKnightTour {

    public boolean checkValidGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        return backtrack(grid, m * n, 0, 0, 0);
    }

    private boolean backtrack(int[][] grid, int last, int row, int col, int step) {
        if (step == last) return true;
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return false;
        if (grid[row][col] != step) return false;

        return backtrack(grid, last, row + 2, col + 1, step + 1)
                || backtrack(grid, last, row + 2, col - 1, step + 1)
                || backtrack(grid, last, row - 2, col + 1, step + 1)
                || backtrack(grid, last, row - 2, col - 1, step + 1)
                || backtrack(grid, last, row + 1, col + 2, step + 1)
                || backtrack(grid, last, row - 1, col + 2, step + 1)
                || backtrack(grid, last, row + 1, col - 2, step + 1)
                || backtrack(grid, last, row - 1, col - 2, step + 1);
    }
}
