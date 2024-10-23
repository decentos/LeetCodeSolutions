package matrix;

public class M36ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int[][] rows = new int[n][n + 1];
        int[][] cols = new int[n][n + 1];
        int[][] boxes = new int[n][n + 1];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == '.') {
                    continue;
                }

                int curr = board[row][col] - '0';
                int box = (row / 3) * 3 + (col / 3);

                if (rows[row][curr] > 0 || cols[col][curr] > 0 || boxes[box][curr] > 0) {
                    return false;
                }

                rows[row][curr]++;
                cols[col][curr]++;
                boxes[box][curr]++;
            }
        }
        return true;
    }
}
