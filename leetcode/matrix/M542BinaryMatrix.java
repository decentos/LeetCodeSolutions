package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class M542BinaryMatrix {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[m][n];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                    seen[row][col] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] dir : dirs) {
                int row = curr[0] + dir[0];
                int col = curr[1] + dir[1];

                if (row < 0 || col < 0 || row >= m || col >= n || seen[row][col]) continue;

                mat[row][col] = mat[curr[0]][curr[1]] + 1;
                queue.offer(new int[]{row, col});
                seen[row][col] = true;
            }
        }
        return mat;
    }
}
