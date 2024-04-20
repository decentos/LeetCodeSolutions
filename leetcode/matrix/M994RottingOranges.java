package matrix;

import java.util.ArrayDeque;
import java.util.Deque;

public class M994RottingOranges {

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> queue = new ArrayDeque<>();
        int fresh = 0, minutes = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    fresh++;
                } else if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        if (fresh == 0) {
            return minutes;
        }

        while (!queue.isEmpty()) {
            if (fresh == 0) {
                return minutes;
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for (int[] dir : dirs) {
                    int row = curr[0] + dir[0];
                    int col = curr[1] + dir[1];

                    if (row >= 0 && col >= 0 && row < m && col < n && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        fresh--;
                        queue.offer(new int[]{row, col});
                    }
                }
            }
            minutes++;
        }
        return -1;
    }
}
