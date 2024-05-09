package graph.dijkstra;

import java.util.PriorityQueue;
import java.util.Queue;

public class H499TheMaze3 {

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length, n = maze[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        char[] instructions = {'d', 'u', 'r', 'l'};
        boolean[][] visited = new boolean[m][n];

        Queue<Position> positions = new PriorityQueue<>();
        positions.offer(new Position(ball[0], ball[1], 0, ""));

        while (!positions.isEmpty()) {
            Position curr = positions.poll();

            if (curr.row == hole[0] && curr.col == hole[1]) {
                return curr.way;
            }
            visited[curr.row][curr.col] = true;

            for (int i = 0; i < 4; i++) {
                int row = curr.row;
                int col = curr.col;
                int steps = curr.steps;

                while (row >= 0 && row < m && col >= 0 && col < n && maze[row][col] == 0 && (row != hole[0] || col != hole[1])) {
                    row += dirs[i][0];
                    col += dirs[i][1];
                    steps++;
                }

                if (row != hole[0] || col != hole[1]) {
                    row -= dirs[i][0];
                    col -= dirs[i][1];
                    steps--;
                }

                if (!visited[row][col]) {
                    positions.offer(new Position(row, col, steps, curr.way + instructions[i]));
                }
            }
        }
        return "impossible";
    }

    private static class Position implements Comparable<Position> {
        int row;
        int col;
        int steps;
        String way;

        public Position(int row, int col, int steps, String way) {
            this.row = row;
            this.col = col;
            this.steps = steps;
            this.way = way;
        }

        @Override
        public int compareTo(Position o) {
            if (this.steps == o.steps) {
                return this.way.compareTo(o.way);
            }
            return Integer.compare(this.steps, o.steps);
        }
    }
}
