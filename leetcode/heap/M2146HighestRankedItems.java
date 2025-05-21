package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class M2146HighestRankedItems {

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        List<List<Integer>> topK = new ArrayList<>();
        Queue<Rank> heap = new PriorityQueue<>();
        heap.offer(new Rank(0, grid[start[0]][start[1]], start[0], start[1]));


        while (!heap.isEmpty() && topK.size() < k) {
            Rank curr = heap.poll();

            if (curr.price >= pricing[0] && curr.price <= pricing[1]) {
                topK.add(List.of(curr.row, curr.col));
            }

            for (int[] dir : dirs) {
                int nextRow = curr.row + dir[0];
                int nextCol = curr.col + dir[1];

                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n
                        || grid[nextRow][nextCol] == 0 || visited[nextRow][nextCol]) {
                    continue;
                }

                visited[nextRow][nextCol] = true;
                heap.offer(new Rank(curr.distance + 1, grid[nextRow][nextCol], nextRow, nextCol));
            }
        }
        return topK;
    }

    private record Rank(int distance, int price, int row, int col) implements Comparable<Rank> {

        @Override
        public int compareTo(Rank o) {
            if (this.distance != o.distance) {
                return this.distance - o.distance;
            } else if (this.price != o.price) {
                return this.price - o.price;
            } else if (this.row != o.row) {
                return this.row - o.row;
            } else {
                return this.col - o.col;
            }
        }
    }
}
