package graph.dijkstra;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class M1631PathMinEffort {

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int effort = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int row = curr[0];
            int col = curr[1];
            int currEffort = curr[2];

            visited[row][col] = true;
            effort = Math.max(effort, currEffort);

            if (row == m - 1 && col == n - 1) {
                return effort;
            }

            for (int[] dir : dirs) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < m && nextCol < n && !visited[nextRow][nextCol]) {
                    int nextEffort = Math.abs(heights[nextRow][nextCol] - heights[row][col]);
                    pq.offer(new int[]{nextRow, nextCol, nextEffort});
                }
            }
        }
        return effort;
    }
}
