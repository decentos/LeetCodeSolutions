package matrix;

import java.util.HashMap;
import java.util.Map;

public class M2352EqualRowCol {

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;
        Map<String, Integer> rows = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append(grid[i][j]).append("-");
            }
            rows.merge(row.toString(), 1, Integer::sum);
        }

        for (int i = 0; i < n; i++) {
            StringBuilder col = new StringBuilder();
            for (int j = 0; j < n; j++) {
                col.append(grid[j][i]).append("-");
            }
            count += rows.getOrDefault(col.toString(), 0);
        }

        return count;
    }
}
