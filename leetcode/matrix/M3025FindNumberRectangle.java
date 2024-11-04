package matrix;

import java.util.Arrays;

public class M3025FindNumberRectangle {

    public int numberOfPairs(int[][] points) {
        int n = points.length, pairs = 0;
        Arrays.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        for (int i = 0; i < n; i++) {
            int y1 = points[i][1], max = Integer.MIN_VALUE;

            for (int j = i + 1; j < n; j++) {
                int y2 = points[j][1];

                if (y1 >= y2 && y2 > max) {
                    pairs++;
                    max = y2;
                }
            }
        }
        return pairs;
    }
}
