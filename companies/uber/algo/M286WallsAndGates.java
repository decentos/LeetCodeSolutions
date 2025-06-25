package uber.algo;

import java.util.ArrayDeque;
import java.util.Deque;

public class M286WallsAndGates {

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> queue = new ArrayDeque<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == 0) {
                    queue.offer(new int[]{row, col, 0});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] dir : dirs) {
                int nextRow = curr[0] + dir[0];
                int nextCol = curr[1] + dir[1];
                int nextDistance = curr[2] + 1;

                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && rooms[nextRow][nextCol] == Integer.MAX_VALUE) {
                    rooms[nextRow][nextCol] = nextDistance;
                    queue.offer(new int[]{nextRow, nextCol, nextDistance});
                }
            }
        }
    }
}
