package matrix;

public class M48RotateImage {

    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    private void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n; row++) {
            for (int col = row + 1; col < n; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }

    private void reverse(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n / 2; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][n - col - 1];
                matrix[row][n - col - 1] = temp;
            }
        }
    }

// ===============================================================================

    public void rotate2(int[][] matrix) {
        int n = matrix.length, start = 0;
        while (start < n / 2) {
            for (int i = start; i < n - 1 - start; i++) {
                int temp = matrix[n - 1 - i][start];
                matrix[n - 1 - i][start] = matrix[n - 1 - start][n - 1 - i];
                matrix[n - 1 - start][n - 1 - i] = matrix[i][n - 1 - start];
                matrix[i][n - 1 - start] = matrix[start][i];
                matrix[start][i] = temp;
            }
            start++;
        }
    }
}
