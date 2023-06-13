package matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class M2352EqualRowCol {

    public int equalPairs(int[][] grid) {
        int count = 0, n = grid.length;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int index = 0;
                while (index < n && grid[row][index] == grid[index][col]) {
                    index++;
                }
                if (index == n) count++;
            }
        }
        return count;
    }

    public int equalPairs2(int[][] grid) {
        int n = grid.length, count = 0;

        Map<String, Integer> rowMap = new HashMap<>();
        for (int[] rows : grid) {
            rowMap.merge(Arrays.toString(rows), 1, Integer::sum);
        }

        for (int col = 0; col < n; col++) {
            int[] colArr = new int[n];
            for (int row = 0; row < n; row++) {
                colArr[row] = grid[row][col];
            }
            count += rowMap.getOrDefault(Arrays.toString(colArr), 0);
        }
        return count;
    }
}
