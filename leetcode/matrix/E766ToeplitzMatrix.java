package matrix;

import java.util.stream.IntStream;

public class E766ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) return false;
            }
        }
        return true;
    }

    public boolean isToeplitzMatrix2(int[][] matrix) {
        return IntStream.range(0, matrix.length - 1).noneMatch(i -> IntStream.range(0, matrix[0].length - 1).anyMatch(j -> matrix[i][j] != matrix[i + 1][j + 1]));
    }
}
