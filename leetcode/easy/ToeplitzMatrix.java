package easy;

public class ToeplitzMatrix {

    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == matrix.length - 1 || j == matrix[i].length - 1) break;
                if (matrix[i][j] != matrix[i + 1][j+1]) return false;
            }
        }
        return true;
    }
}
