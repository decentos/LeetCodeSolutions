package medium;

import java.util.ArrayList;
import java.util.List;

public class M57InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] added = new int[n + 1][2];
        int index = 0;
        while (index < n && intervals[index][0] < newInterval[0]) {
            added[index] = intervals[index];
            index++;
        }
        added[index] = newInterval;
        while (index < n) {
            added[index + 1] = intervals[index];
            index++;
        }

        List<int[]> merged = new ArrayList<>();
        merged.add(added[0]);

        for (int i = 1; i <= n; i++) {
            int[] curr = merged.get(merged.size() - 1);
            if (curr[1] >= added[i][0]) {
                curr[1] = Math.max(curr[1], added[i][1]);
            } else {
                merged.add(added[i]);
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }

// ===============================================================================

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> merged = new ArrayList<>();
        int index = 0;

        while (index < n && intervals[index][1] < newInterval[0]) {
            merged.add(intervals[index]);
            index++;
        }

        while (index < n && intervals[index][0] <= newInterval[1]) {
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
