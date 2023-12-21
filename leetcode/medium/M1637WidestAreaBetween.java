package medium;

import java.util.Arrays;
import java.util.Comparator;

public class M1637WidestAreaBetween {

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int max = 0;

        for (int i = 1; i < points.length; i++) {
            int curr = points[i][0] - points[i - 1][0];
            max = Math.max(max, curr);
        }
        return max;
    }
}
