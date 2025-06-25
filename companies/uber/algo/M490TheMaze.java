package uber.algo;

import java.util.ArrayDeque;
import java.util.Deque;

public class M490TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            if (currRow == destination[0] && currCol == destination[1]) {
                return true;
            }

            for (int[] dir : dirs) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];

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
