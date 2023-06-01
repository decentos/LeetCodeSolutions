package matrix;

import java.util.ArrayDeque;
import java.util.Queue;

public class M1091ShortestPathBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int end = grid.length - 1;
        if (grid[0][0] != 0 || grid[end][end] != 0) return -1;

        int path = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, -1}, {-1, -1}, {-1, 1}, {1, 1}};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            path++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int currRow = curr[0];
                int currCol = curr[1];

                if (currRow == end && currCol == end) return path;

                for (int[] dir : dirs) {
                    int nextRow = currRow + dir[0];
                    int nextCol = currCol + dir[1];

                    if (nextRow < 0 || nextCol < 0 || nextRow > end || nextCol > end || grid[nextRow][nextCol] == 1) continue;

                    queue.offer(new int[]{nextRow, nextCol});
                    grid[nextRow][nextCol] = 1;
                }
            }
        }
        return -1;
    }
}
