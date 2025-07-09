package uber.algo;

import java.util.List;

public class M1428ColumnLeastOne {

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0), cols = dimensions.get(1);
        int minCol = cols;

        for (int row = 0; row < rows; row++) {
            int left = 0, right = minCol - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int val = binaryMatrix.get(row, mid);

                if (val == 1) {
                    minCol = Math.min(minCol, mid);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return minCol == cols ? -1 : minCol;
    }

    public record BinaryMatrix(int[][] matrix) {

        public int get(int row, int col) {
            return matrix[row][col];
        }

        public List<Integer> dimensions() {
            return List.of(matrix.length, matrix[0].length);
        }
    }
}
