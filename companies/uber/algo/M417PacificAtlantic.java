package uber.algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class M417PacificAtlantic {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> both = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        Deque<int[]> pQueue = new ArrayDeque<>();
        Deque<int[]> aQueue = new ArrayDeque<>();

        for (int row = 0; row < m; row++) {
            pQueue.offer(new int[]{row, 0});
            aQueue.offer(new int[]{row, n - 1});
        }

        for (int col = 0; col < n; col++) {
            pQueue.offer(new int[]{0, col});
            aQueue.offer(new int[]{m - 1, col});
        }

        boolean[][] pReachable = getReachable(heights, pQueue);
        boolean[][] aReachable = getReachable(heights, aQueue);

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (pReachable[row][col] && aReachable[row][col]) {
                    both.add(List.of(row, col));
                }
            }
        }
        return both;
    }

    private boolean[][] getReachable(int[][] heights, Deque<int[]> queue) {
        int m = heights.length, n = heights[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] isReachable = new boolean[m][n];

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            isReachable[currRow][currCol] = true;

            for (int[] dir : dirs) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];

                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n
                        && !isReachable[nextRow][nextCol] && heights[nextRow][nextCol] >= heights[currRow][currCol]) {
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }
        return isReachable;
    }
}
