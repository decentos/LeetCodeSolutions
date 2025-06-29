package uber.algo;

import java.util.HashMap;
import java.util.Map;

public class M2768NumberBlackBlocks {

    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        long[] result = new long[5];
        result[0] = (m - 1L) * (n - 1L);
        int[][] dirs = {{0, 0}, {-1, 0}, {0, -1}, {-1, -1}};
        Map<Long, Map<Long, Long>> counter = new HashMap<>();

        for (int[] pos : coordinates) {
            for (int[] dir : dirs) {
                long row = pos[0] + dir[0];
                long col = pos[1] + dir[1];

                if (row < 0 || row >= m - 1 || col < 0 || col >= n - 1) {
                    continue;
                }

                Map<Long, Long> colMap = counter.computeIfAbsent(row, val -> new HashMap<>());
                long blackCount = colMap.merge(col, 1L, Long::sum);

                result[(int) blackCount - 1]--;
                result[(int) blackCount]++;
            }
        }
        return result;
    }
}
