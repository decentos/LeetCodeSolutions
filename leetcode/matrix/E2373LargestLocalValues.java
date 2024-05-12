package matrix;

public class E2373LargestLocalValues {

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] max = new int[n - 2][n - 2];

        for (int row = 0; row < n - 2; row++) {
            for (int col = 0; col < n - 2; col++) {

                for (int localRow = row; localRow < row + 3; localRow++) {
                    for (int localCol = col; localCol < col + 3; localCol++) {
                        max[row][col] = Math.max(max[row][col], grid[localRow][localCol]);
                    }
                }
            }
        }
        return max;
    }
}
