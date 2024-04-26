package dp;

import java.util.Arrays;

public class H1289MinimumPathSum2 {

    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] sum = new int[n][n];
        for (int[] arr : sum) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        sum[0] = grid[0];

        int minCol1 = -1, minCol2 = -1;
        for (int col = 0; col < n; col++) {
            if (minCol1 == -1 || grid[0][col] < grid[0][minCol1]) {
                minCol2 = minCol1;
                minCol1 = col;
            } else if (minCol2 == -1 || grid[0][col] < grid[0][minCol2]) {
                minCol2 = col;
            }
        }

        for (int row = 1; row < n; row++) {
            int currMinCol1 = -1, currMinCol2 = -1;

            for (int col = 0; col < n; col++) {

                if (minCol1 != col) {
                    sum[row][col] = sum[row - 1][minCol1] + grid[row][col];
                } else {
                    sum[row][col] = sum[row - 1][minCol2] + grid[row][col];
                }

                if (currMinCol1 == -1 || sum[row][col] < sum[row][currMinCol1]) {
                    currMinCol2 = currMinCol1;
                    currMinCol1 = col;
                } else if (currMinCol2 == -1 || sum[row][col] < sum[row][currMinCol2]) {
                    currMinCol2 = col;
                }
            }

            minCol1 = currMinCol1;
            minCol2 = currMinCol2;
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
    public int minFallingPathSum2(int[][] grid) {
        int n = grid.length;
        int min1 = -1, min2 = -1;
        int minCol1 = -1;

        for (int col = 0; col < n; col++) {
            if (min1 == -1 || grid[0][col] < min1) {
                min2 = min1;
                min1 = grid[0][col];
                minCol1 = col;
            } else if (min2 == -1 || grid[0][col] < min2) {
                min2 = grid[0][col];
            }
        }

        for (int row = 1; row < n; row++) {
            int currMin1 = -1, currMin2 = -1;
            int currMinCol1 = -1;

            for (int col = 0; col < n; col++) {
                int value = minCol1 != col ? min1 : min2;
                value += grid[row][col];

                if (currMin1 == -1 || value < currMin1) {
                    currMin2 = currMin1;
                    currMin1 = value;
                    currMinCol1 = col;
                } else if (currMin2 == -1 || value < currMin2) {
                    currMin2 = value;
                }
            }

            min1 = currMin1;
            min2 = currMin2;
            minCol1 = currMinCol1;
        }
        return min1;
    }
}
