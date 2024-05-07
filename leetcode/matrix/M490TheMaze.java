package matrix;

import java.util.ArrayDeque;
import java.util.Deque;

public class M490TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }

            for (int[] dir : dirs) {
                int nextRow = curr[0] += dir[0];
                int nextCol = curr[1] += dir[1];

                while (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && maze[nextRow][nextCol] == 0) {
                    nextRow += dir[0];
                    nextCol += dir[1];
                }

                nextRow -= dir[0];
                nextCol -= dir[1];

                if (!visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }
        return false;
    }
}
