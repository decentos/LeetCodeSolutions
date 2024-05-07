package graph.dijkstra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class M505TheMaze2 {

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int[][] dist = new int[m][n];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;

        Queue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        heap.offer(new int[]{start[0], start[1], 0});

        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int row = curr[0];
            int col = curr[1];
            int steps = curr[2];

            if (row == destination[0] && col == destination[1]) {
                return steps;
            }

            for (int[] dir : dirs) {
                int nextRow = row;
                int nextCol = col;
                int nextSteps = steps;

                while (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && maze[nextRow][nextCol] == 0) {
                    nextRow += dir[0];
                    nextCol += dir[1];
                    nextSteps++;
                }

                nextRow -= dir[0];
                nextCol -= dir[1];
                nextSteps--;

                if (nextSteps < dist[nextRow][nextCol]) {
                    dist[nextRow][nextCol] = nextSteps;
                    heap.offer(new int[]{nextRow, nextCol, nextSteps});
                }
            }
        }
        return -1;
    }
}
