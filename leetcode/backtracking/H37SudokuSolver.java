package backtracking;

public class H37SudokuSolver {
    private final int boxSize = 3;
    private final int size = boxSize * boxSize;
    private final boolean[][] rows = new boolean[size][size];
    private final boolean[][] cols = new boolean[size][size];
    private final boolean[][] boxes = new boolean[size][size];
    private final char[] digits = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public void solveSudoku(char[][] board) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == '.') continue;
                int num = board[row][col] - '1';
                int box = boxSize * (row / boxSize) + col / boxSize;
                rows[row][num] = cols[col][num] = boxes[box][num] = true;
            }
        }
        fill(board, 0);
    }

    private boolean fill(char[][] board, int rowIndex) {
        for (int row = rowIndex; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] != '.') continue;

                for (char curr : digits) {
                    int num = curr - '1';
                    int box = boxSize * (row / boxSize) + col / boxSize;
                    if (rows[row][num] || cols[col][num] || boxes[box][num]) continue;

                    board[row][col] = curr;
                    rows[row][num] = cols[col][num] = boxes[box][num] = true;

                    if (fill(board, row)) return true;

                    board[row][col] = '.';
                    rows[row][num] = cols[col][num] = boxes[box][num] = false;
                }
                return false;
            }
        }
        return true;
    }
}
