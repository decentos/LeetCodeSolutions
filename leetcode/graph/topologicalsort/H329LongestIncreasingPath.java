package graph.topologicalsort;

import java.util.ArrayDeque;
import java.util.Deque;

public class H329LongestIncreasingPath {

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] inDegree = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                for (int[] dir : dirs) {
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];

                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && matrix[row][col] < matrix[nextRow][nextCol]) {
                        inDegree[nextRow][nextCol]++;
                    }
                }
            }
        }

        Deque<int[]> queue = new ArrayDeque<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (inDegree[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        int height = 0;
        while (!queue.isEmpty()) {
            height++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for (int[] dir : dirs) {
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];

                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && matrix[row][col] < matrix[nextRow][nextCol]) {
                        inDegree[nextRow][nextCol]--;

                        if (inDegree[nextRow][nextCol] == 0) {
                            queue.offer(new int[]{nextRow, nextCol});
                        }
                    }
                }
            }
        }
        return height;
    }
}
