package matrix;

public class E2022ConvertArrayInto2D {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[0][0];
        }

        int[][] converted = new int[m][n];
        int row = 0, col = 0;

        for (int num : original) {
            converted[row][col++] = num;

            if (col == n) {
                row++;
                col = 0;
            }
        }
        return converted;
    }
}
