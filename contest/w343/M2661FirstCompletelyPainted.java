package w343;

import java.util.HashMap;
import java.util.Map;

public class M2661FirstCompletelyPainted {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curr = mat[i][j];
                map.put(curr, new int[]{i, j});
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int[] curr = map.get(arr[i]);
            rows[curr[0]]++;
            cols[curr[1]]++;
            if (rows[curr[0]] == n || cols[curr[1]] == m) return i;
        }
        return -1;
    }
}
