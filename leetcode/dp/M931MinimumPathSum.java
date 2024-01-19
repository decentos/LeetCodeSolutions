package dp;

public class M931MinimumPathSum {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int curr = matrix[row][col];
                int left = col > 0 ? curr + matrix[row - 1][col - 1] : Integer.MAX_VALUE;
                int mid = curr + matrix[row - 1][col];
                int right = col < n - 1 ? curr + matrix[row - 1][col + 1] : Integer.MAX_VALUE;
                matrix[row][col] = Math.min(left, Math.min(mid, right));
            }
        }

        int min = Integer.MAX_VALUE;
        for (int curr : matrix[n - 1]) {
            min = Math.min(min, curr);
        }
        return min;
    }
}
