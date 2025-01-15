package matrix;

import java.util.ArrayDeque;
import java.util.Deque;

public class M1730ShortestPathFood {

    public int getFood(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> cells = new ArrayDeque<>();
        int[] location = getLocation(grid, visited);
        cells.offer(location);
        int steps = 0;

        while (!cells.isEmpty()) {
            int size = cells.size();
            steps++;

            for (int i = 0; i < size; i++) {
                int[] cell = cells.poll();

                for (int[] dir : dirs) {
                    int nextRow = cell[0] + dir[0];
                    int nextCol = cell[1] + dir[1];

                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || grid[nextRow][nextCol] == 'X' || visited[nextRow][nextCol]) {
                        continue;
                    }

                    if (grid[nextRow][nextCol] == '#') {
                        return steps;
                    }

                    visited[nextRow][nextCol] = true;
                    cells.offer(new int[]{nextRow, nextCol});
                }
            }
        }
        return -1;
    }

    private int[] getLocation(char[][] grid, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == '*') {
                    visited[row][col] = true;
                    return new int[]{row, col};
                }
            }
        }
        return new int[0];
    }
}
