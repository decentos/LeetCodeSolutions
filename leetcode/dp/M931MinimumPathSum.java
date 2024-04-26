package dp;

import java.util.Arrays;

public class M931MinimumPathSum {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}};
        int[][] sum = new int[n][n];
        for (int[] arr : sum) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        sum[0] = matrix[0];

        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {

                for (int[] dir : dirs) {
                    int prevRow = row + dir[0];
                    int prevCol = col + dir[1];

                    if (prevRow >= 0 && prevCol >= 0 && prevCol < n) {
                        sum[row][col] = Math.min(sum[row][col], sum[prevRow][prevCol] + matrix[row][col]);
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int[] lastRow = sum[n - 1];
        for (int col : lastRow) {
            min = Math.min(min, col);
        }
        return min;
    }

// ===============================================================================

    // Space optimization
    public int minFallingPathSum2(int[][] matrix) {
        int n = matrix.length;
        int[] sum = matrix[0];

        for (int row = 1; row < n; row++) {
            int[] currRow = new int[n];

            for (int col = 0; col < n; col++) {
                int left = col - 1 >= 0 ? sum[col - 1] : Integer.MAX_VALUE;
                int mid = sum[col];
                int right = col + 1 < n ? sum[col + 1] : Integer.MAX_VALUE;

                currRow[col] = Math.min(mid, Math.min(left, right)) + matrix[row][col];
            }
            sum = currRow;
        }

        int min = Integer.MAX_VALUE;
        for (int col : sum) {
            min = Math.min(min, col);
        }
        return min;
    }
}
