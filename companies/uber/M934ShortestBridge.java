package uber;

import java.util.ArrayDeque;
import java.util.Deque;

public class M934ShortestBridge {

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[n][n];
        Deque<int[]> island = new ArrayDeque<>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    findIsland(grid, island, visited, row, col);
                    break;
                }
            }

            if (!island.isEmpty()) {
                break;
            }
        }

        int step = 0;
        while (!island.isEmpty()) {
            int size = island.size();

            for (int i = 0; i < size; i++) {
                int[] curr = island.poll();
                int currRow = curr[0];
                int currCol = curr[1];

                for (int[] dir : dirs) {
                    int nextRow = currRow + dir[0];
                    int nextCol = currCol + dir[1];

                    if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {
                        continue;
                    }

                    if (grid[nextRow][nextCol] == 1) {
                        return step;
                    } else {
                        visited[nextRow][nextCol] = true;
                        island.offer(new int[]{nextRow, nextCol});
                    }
                }
            }
            step++;

        }
        return -1;
    }

    private void findIsland(int[][] grid, Deque<int[]> island, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid.length || grid[row][col] == 0 || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        island.offer(new int[]{row, col});

        findIsland(grid, island, visited, row + 1, col);
        findIsland(grid, island, visited, row - 1, col);
        findIsland(grid, island, visited, row, col + 1);
        findIsland(grid, island, visited, row, col - 1);
    }
}
