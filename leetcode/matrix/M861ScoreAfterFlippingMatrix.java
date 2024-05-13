package matrix;

public class M861ScoreAfterFlippingMatrix {

    public int matrixScore(int[][] grid) {
        int n = grid[0].length;

        for (int[] row : grid) {
            if (row[0] == 0) {
                flipRow(row);
            }
        }

        for (int col = 1; col < n; col++) {
            if (hasColMoreZeros(grid, col)) {
                flipCol(grid, col);
            }
        }

        int sum = 0;
        for (int[] row : grid) {
            int curr = 0;
            for (int col = 0; col < n; col++) {
                curr = curr * 2 + row[col];
            }
            sum += curr;
        }
        return sum;
    }

    private void flipRow(int[] row) {
        for (int col = 0; col < row.length; col++) {
            row[col] = 1 - row[col];
        }
    }

    private boolean hasColMoreZeros(int[][] grid, int col) {
        int zeros = 0;
        for (int[] row : grid) {
            if (row[col] == 0) {
                zeros++;
            }
        }
        return zeros * 2 > grid.length;
    }

    private void flipCol(int[][] grid, int col) {
        for (int row = 0; row < grid.length; row++) {
            grid[row][col] = 1 - grid[row][col];
        }
    }
}
