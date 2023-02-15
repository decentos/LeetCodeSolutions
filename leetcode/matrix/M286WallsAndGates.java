package matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M286WallsAndGates {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{0, -1}
    );

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> gates = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == GATE) gates.offer(new int[]{row, col});
            }
        }

        while (!gates.isEmpty()) {
            int[] currGate = gates.poll();
            int row = currGate[0];
            int col = currGate[1];

            for (int[] d : DIRECTIONS) {
                int currRow = row + d[0];
                int currCol = col + d[1];
                if (currRow < 0 || currCol < 0 || currRow >= m || currCol >= n || rooms[currRow][currCol] != EMPTY) continue;
                rooms[currRow][currCol] = rooms[row][col] + 1;
                gates.offer(new int[]{currRow, currCol});
            }
        }
    }
}
