package backtracking;

public class M79WordSearch {

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int col, int row, int index) {
        if (index >= word.length()) {
            return true;
        } else if (col < 0 || row < 0 || col == board.length || row == board[0].length || board[col][row] != word.charAt(index)) {
            return false;
        }

        board[col][row] = '#';
        boolean result = backtrack(board, word, col + 1, row, index + 1)
                || backtrack(board, word, col - 1, row, index + 1)
                || backtrack(board, word, col, row + 1, index + 1)
                || backtrack(board, word, col, row - 1, index + 1);
        board[col][row] = word.charAt(index);
        return result;
    }
}
