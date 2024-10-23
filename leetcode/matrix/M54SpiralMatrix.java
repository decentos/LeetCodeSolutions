package matrix;

import java.util.ArrayList;
import java.util.List;

public class M54SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> spiral = new ArrayList<>();
        int row = 0, col = 0;

        while (spiral.size() < m * n) {
            while (col < n && matrix[row][col] != 101) {
                spiral.add(matrix[row][col]);
                matrix[row][col] = 101;
                col++;
            }
            col--;
            row++;

            while (row < m && matrix[row][col] != 101) {
                spiral.add(matrix[row][col]);
                matrix[row][col] = 101;
                row++;
            }
            row--;
            col--;

            while (col >= 0 && matrix[row][col] != 101) {
                spiral.add(matrix[row][col]);
                matrix[row][col] = 101;
                col--;
            }
            col++;
            row--;

            while (row >= 0 && matrix[row][col] != 101) {
                spiral.add(matrix[row][col]);
                matrix[row][col] = 101;
                row--;
            }
            row++;

            col++;
        }
        return spiral;
    }
}
