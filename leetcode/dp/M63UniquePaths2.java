package dp;

public class M63UniquePaths2 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        obstacleGrid[0][0] = 1;

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        for (int col = 1; col < m; col++) {
            if (obstacleGrid[col][0] == 1) {
                while (col < m) {
                    obstacleGrid[col][0] = 0;
                    col++;
                }
            } else {
                obstacleGrid[col][0] = 1;
            }
        }
        for (int row = 1; row < n; row++) {
            if (obstacleGrid[0][row] == 1) {
                while (row < n) {
                    obstacleGrid[0][row] = 0;
                    row++;
                }
            } else {
                obstacleGrid[0][row] = 1;
            }
        }

        for (int col = 1; col < m; col++) {
            for (int row = 1; row < n; row++) {
                if (obstacleGrid[col][row] == 1) {
                    obstacleGrid[col][row] = 0;
                } else {
                    obstacleGrid[col][row] = obstacleGrid[col - 1][row] + obstacleGrid[col][row - 1];
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
}
