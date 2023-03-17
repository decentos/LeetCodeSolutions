package backtracking;

public class M79WordSearch {

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int index, int row, int col) {
        if (index >= word.length()) return true;
        if (row < 0 || col < 0 || row == board.length || col == board[0].length) return false;
        if (board[row][col] != word.charAt(index)) return false;

        board[row][col] = '#';
        boolean exist = backtrack(board, word, index + 1, row + 1, col)
                || backtrack(board, word, index + 1, row - 1, col)
                || backtrack(board, word, index + 1, row, col + 1)
                || backtrack(board, word, index + 1, row, col - 1);
        board[row][col] = word.charAt(index);
        return exist;
    }
}
