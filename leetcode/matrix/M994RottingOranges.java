package matrix;

import java.util.ArrayDeque;
import java.util.Deque;

public class M994RottingOranges {

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int minutes = 0;
        int freshCount = 0;
        Deque<int[]> rotten = new ArrayDeque<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    freshCount++;
                } else if (grid[row][col] == 2) {
                    rotten.offer(new int[]{row, col});
                }
            }
        }

        while (!rotten.isEmpty() && freshCount > 0) {
            int size = rotten.size();

            for (int i = 0; i < size; i++) {
                int[] curr = rotten.poll();

                for (int[] dir : dirs) {
                    int nextRow = curr[0] + dir[0];
                    int nextCol = curr[1] + dir[1];

                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || grid[nextRow][nextCol] != 1) {
                        continue;
                    }

                    grid[nextRow][nextCol] = 2;
                    freshCount--;
                    rotten.offer(new int[]{nextRow, nextCol});
                }
            }
            minutes++;
        }
        return freshCount == 0 ? minutes : -1;
    }
}
