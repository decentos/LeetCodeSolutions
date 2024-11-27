package matrix;

public class M130SurroundedRegions {

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int col = 0; col < n; col++) {
            if (board[0][col] == 'O' && !visited[0][col]) {
                visit(board, visited, 0, col);
            }
            if (board[m - 1][col] == 'O' && !visited[m - 1][col]) {
                visit(board, visited, m - 1, col);
            }
        }

        for (int row = 0; row < m; row++) {
            if (board[row][0] == 'O' && !visited[row][0]) {
                visit(board, visited, row, 0);
            }
            if (board[row][n - 1] == 'O' && !visited[row][n - 1]) {
                visit(board, visited, row, n - 1);
            }
        }

        for (int row = 1; row < m - 1; row++) {
            for (int col = 1; col < n - 1; col++) {
                if (board[row][col] == 'O' && !visited[row][col]) {
                    board[row][col] = 'X';
                }
            }
        }
    }

    private void visit(char[][] board, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == 'X' || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        visit(board, visited, row + 1, col);
        visit(board, visited, row - 1, col);
        visit(board, visited, row, col + 1);
        visit(board, visited, row, col - 1);
    }
}
