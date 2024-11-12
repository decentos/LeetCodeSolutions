package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class M56MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int n = intervals.length;
        List<int[]> merged = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int startInterval = intervals[i][0];
            int endInterval = intervals[i][1];

            while (i + 1 < n && endInterval >= intervals[i + 1][0]) {
                endInterval = Math.max(endInterval, intervals[i + 1][1]);
                i++;
            }

            merged.add(new int[]{startInterval, endInterval});
        }
        return merged.toArray(new int[merged.size()][2]);
    }
}
