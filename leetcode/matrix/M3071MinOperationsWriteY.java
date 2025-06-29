package matrix;

public class M3071MinOperationsWriteY {

    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int[] yCount = new int[3];
        int[] nonYCount = new int[3];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (isY(n, row, col)) {
                    yCount[grid[row][col]]++;
                } else {
                    nonYCount[grid[row][col]]++;
                }
            }
        }

        int max = 0;
        for (int y = 0; y < 3; y++) {
            for (int nonY = 0; nonY < 3; nonY++) {
                if (y != nonY) {
                    max = Math.max(max, yCount[y] + nonYCount[nonY]);
                }
            }
        }
        return n * n - max;
    }

    private boolean isY(int n, int row, int col) {
        return (row == col && row < n / 2) || (row + col == n - 1 && row < n / 2) || (col == n / 2 && row >= n / 2);
    }
}
