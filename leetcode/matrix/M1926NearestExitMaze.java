package matrix;

import java.util.ArrayDeque;
import java.util.Deque;

public class M1926NearestExitMaze {

    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[entrance[0]][entrance[1]] = true;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(entrance);
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int currRow = curr[0];
                int currCol = curr[1];

                if (isExit(entrance, m, n, currRow, currCol)) {
                    return steps;
                }

                for (int[] dir : dirs) {
                    int nextRow = currRow + dir[0];
                    int nextCol = currCol + dir[1];

                    if (isNotValid(m, n, nextRow, nextCol, visited, maze)) {
                        continue;
                    }

                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
            steps++;
        }
        return -1;
    }

    private boolean isExit(int[] entrance, int m, int n, int row, int col) {
        return !(row == entrance[0] && col == entrance[1]) && (row == 0 || row == m - 1 || col == 0 || col == n - 1);
    }

    private boolean isNotValid(int m, int n, int row, int col, boolean[][] visited, char[][] maze) {
        return row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || maze[row][col] != '.';
    }
}
