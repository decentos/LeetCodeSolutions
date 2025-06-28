package uber.algo;

import java.util.Arrays;

public class M1861RotatingBox {

    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;
        char[][] rotated = new char[n][m];

        // transpose
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                rotated[row][col] = boxGrid[col][row];
            }
        }

        // reverse
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m / 2; col++) {
                char temp = rotated[row][col];
                rotated[row][col] = rotated[row][m - col - 1];
                rotated[row][m - col - 1] = temp;
            }
        }

        for (int col = 0; col < m; col++) {
            int lowestEmptyCell = n - 1;

            for (int row = n - 1; row >= 0; row--) {
                if (rotated[row][col] == '*') {
                    lowestEmptyCell = row - 1;
                } else if (rotated[row][col] == '#') {
                    rotated[row][col] = '.';
                    rotated[lowestEmptyCell][col] = '#';
                    lowestEmptyCell--;
                }
            }
        }
        return rotated;
    }

    public char[][] rotateTheBox2(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;
        char[][] rotated = new char[n][m];

        for (char[] row : rotated) {
            Arrays.fill(row, '.');
        }

        for (int row = 0; row < m; row++) {
            int lowestEmptyCell = n - 1;

            for (int col = n - 1; col >= 0; col--) {
                if (boxGrid[row][col] == '#') {
                    rotated[lowestEmptyCell][m - row - 1] = '#';
                    lowestEmptyCell--;
                } else if (boxGrid[row][col] == '*') {
                    rotated[col][m - row - 1] = '*';
                    lowestEmptyCell = col - 1;
                }
            }
        }
        return rotated;
    }
}
