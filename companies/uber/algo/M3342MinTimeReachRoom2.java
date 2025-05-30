package uber.algo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class M3342MinTimeReachRoom2 {

    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length, n = moveTime[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> path = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        path.offer(new int[]{0, 0, 0, 2});
        visited[0][0] = true;

        while (!path.isEmpty()) {
            int[] curr = path.poll();
            int currRow = curr[0];
            int currCol = curr[1];
            int currTime = curr[2];
            int currCost = curr[3];

            if (currRow == m - 1 && currCol == n - 1) {
                return currTime;
            }

            for (int[] dir : dirs) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];

                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {
                    continue;
                }
                visited[nextRow][nextCol] = true;
                int nextCost = currCost == 1 ? 2 : 1;
                path.offer(new int[]{nextRow, nextCol, Math.max(currTime, moveTime[nextRow][nextCol]) + nextCost, nextCost});
            }
        }
        return -1;
    }
}
