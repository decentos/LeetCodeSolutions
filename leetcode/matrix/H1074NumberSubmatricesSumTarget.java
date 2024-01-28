package matrix;

import java.util.HashMap;
import java.util.Map;

public class H1074NumberSubmatricesSumTarget {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int prefix = 0;

                for (int k = 0; k < m; k++) {
                    prefix += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
                    count += map.getOrDefault(prefix - target, 0);
                    map.merge(prefix, 1, Integer::sum);
                }
            }
        }

        return count;
    }
}
