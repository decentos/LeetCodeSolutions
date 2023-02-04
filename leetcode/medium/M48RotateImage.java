package medium;

public class M48RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length, start = 0;
        while (start < m / 2) {
            for (int i = start; i < m - 1 - start; i++) {
                int temp = matrix[n - 1 - i][start];
                matrix[n - 1 - i][start] = matrix[n - 1 - start][m - 1 - i];
                matrix[n - 1 - start][m - 1 - i] = matrix[i][m - 1 - start];
                matrix[i][m - 1 - start] = matrix[start][i];
                matrix[start][i] = temp;
            }
            start++;
        }
    }
}
