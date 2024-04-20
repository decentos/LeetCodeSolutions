package matrix;

import java.util.ArrayDeque;
import java.util.Deque;

public class M1091ShortestPathBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        int path = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        Deque<Cell> queue = new ArrayDeque<>();
        queue.offer(new Cell(0, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;

            for (int i = 0; i < size; i++) {
                Cell cell = queue.poll();
                if (cell.row == n - 1 && cell.col == n - 1) {
                    return path;
                }

                for (int[] dir : dirs) {
                    int nextRow = cell.row + dir[0];
                    int nextCol = cell.col + dir[1];

                    if (nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < n && grid[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true;
                        queue.offer(new Cell(nextRow, nextCol));
                    }
                }
            }
        }
        return -1;
    }

    private static class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
