package uber.algo;

public class M79WordSearch {

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (backtrack(board, word, visited, row, col, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, boolean[][] visited, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        } else if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;
        boolean up = backtrack(board, word, visited, row + 1, col, index + 1);
        boolean down = backtrack(board, word, visited, row - 1, col, index + 1);
        boolean left = backtrack(board, word, visited, row, col - 1, index + 1);
        boolean right = backtrack(board, word, visited, row, col + 1, index + 1);
        visited[row][col] = false;
        return up || down || left || right;
    }
}
