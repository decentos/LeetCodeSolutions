package uber.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class M56MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int n = intervals.length;
        List<int[]> merged = new ArrayList<>();

        for (int curr = 0; curr < n; curr++) {
            int startTime = intervals[curr][0];
            int endTime = intervals[curr][1];

            while (curr < n - 1 && endTime >= intervals[curr + 1][0]) {
                endTime = Math.max(endTime, intervals[curr + 1][1]);
                curr++;
            }

            merged.add(new int[]{startTime, endTime});
        }
        return merged.toArray(new int[merged.size()][2]);
    }
}
