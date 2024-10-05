package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class M435NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int currEnd = intervals[0][1], removals = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < currEnd) {
                removals++;
            } else {
                currEnd = intervals[i][1];
            }
        }
        return removals;
    }
}
