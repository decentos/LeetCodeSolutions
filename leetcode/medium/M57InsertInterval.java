package medium;

import java.util.ArrayList;
import java.util.List;

public class M57InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        int n = intervals.length, index = 0;

        while (index < n && intervals[index][1] < newInterval[0]) {
            merged.add(intervals[index]);
            index++;
        }

        while (index < n && newInterval[1] >= intervals[index][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }
        merged.add(newInterval);

        while (index < n) {
            merged.add(intervals[index]);
            index++;
        }
        return merged.toArray(new int[merged.size()][2]);
    }
}
