package medium;

public class M57InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int m = intervals.length;
        int[][] newIntervals = new int[m + 1][2];
        int index = 0, insertIndex = 0;

        while (index < m && intervals[index][1] < newInterval[0]) {
            newIntervals[insertIndex++] = intervals[index++];
        }

        while (index < m && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }
        newIntervals[insertIndex++] = newInterval;

        while (index < m) {
            newIntervals[insertIndex++] = intervals[index++];
        }

        int[][] ans = new int[insertIndex][2];
        System.arraycopy(newIntervals, 0, ans, 0, insertIndex);
        return ans;
    }
}
