package uber.algo;

import java.util.ArrayList;
import java.util.List;

public class M57InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        int n = intervals.length, insertIndex = 0;

        while (insertIndex < n && intervals[insertIndex][1] < newInterval[0]) {
            merged.add(intervals[insertIndex]);
            insertIndex++;
        }

        while (insertIndex < n && newInterval[1] >= intervals[insertIndex][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[insertIndex][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[insertIndex][1]);
            insertIndex++;
        }
        merged.add(newInterval);

        while (insertIndex < n) {
            merged.add(intervals[insertIndex]);
            insertIndex++;
        }
        return merged.toArray(new int[merged.size()][2]);
    }
}
