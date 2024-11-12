package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class M452MinNumberArrows {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int arrows = 1, high = points[0][1];

        for (int[] point : points) {
            if (point[0] > high) {
                arrows++;
                high = point[1];
            }
        }
        return arrows;
    }
}
