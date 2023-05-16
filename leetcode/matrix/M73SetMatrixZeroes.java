package matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class M73SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 0) {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rows.contains(row) || cols.contains(col)) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRow = false, firstCol = false;

        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                firstCol = true;
                break;
            }
        }

        for (int col = 0; col < n; col++) {
            if (matrix[0][col] == 0) {
                firstRow = true;
                break;
            }
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (firstRow) {
            Arrays.fill(matrix[0], 0);
        }

        if (firstCol) {
            for (int row = 0; row < m; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}
