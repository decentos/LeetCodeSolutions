package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class M994RottingOranges {

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        int minutes = -1;
        int freshCount = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                } else if (grid[row][col] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) return 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for (int[] dir : dirs) {
                    int row = curr[0] + dir[0];
                    int col = curr[1] + dir[1];

                    if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == 0 || grid[row][col] == 2) continue;

                    grid[row][col] = 2;
                    freshCount--;
                    queue.offer(new int[]{row, col});
                }
            }
            minutes++;
        }
        return freshCount == 0 ? minutes : -1;
    }
}
