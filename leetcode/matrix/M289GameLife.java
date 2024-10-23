package matrix;

public class M289GameLife {

    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int curr = board[row][col];
                int aliveCount = 0;

                for (int[] dir : dirs) {
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];

                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                        continue;
                    }

                    if (Math.abs(board[nextRow][nextCol]) == 1) {
                        aliveCount++;
                    }
                }

                if (curr == 1 && (aliveCount < 2 || aliveCount > 3)) {
                    board[row][col] = -1;
                } else if (curr == 0 && aliveCount == 3) {
                    board[row][col] = 2;
                }
            }
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }
}
