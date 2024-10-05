package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class M452MinNumberArrows {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int currEnd = points[0][1], arrows = 1;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > currEnd) {
                currEnd = points[i][1];
                arrows++;
            }
        }
        return arrows;
    }
}
