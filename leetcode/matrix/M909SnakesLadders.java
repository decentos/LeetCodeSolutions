package matrix;

import java.util.ArrayDeque;
import java.util.Deque;

public class M909SnakesLadders {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = true;
        int rolls = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int square = queue.poll();

                if (square == n * n) {
                    return rolls;
                }

                for (int next = square + 1; next <= Math.min(square + 6, n * n); next++) {
                    if (!visited[next]) {
                        visited[next] = true;
                        int[] cell = squareToCell(n, next);
                        int row = cell[0], col = cell[1];

                        queue.offer(board[row][col] == -1 ? next : board[row][col]);
                    }
                }
            }
            rolls++;
        }
        return -1;
    }

    private int[] squareToCell(int n, int square) {
        int row = (square - 1) / n;
        int col = (square - 1) % n;
        int x = n - 1 - row;
        int y = row % 2 == 0 ? col : n - 1 - col;
        return new int[]{x, y};
    }
}
