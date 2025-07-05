package uber.algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class M253MeetingRooms2 {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Queue<Integer> heap = new PriorityQueue<>();
        int minRooms = 0;

        for (int[] interval : intervals) {
            while (!heap.isEmpty() && heap.peek() <= interval[0]) {
                heap.poll();
            }
            heap.offer(interval[1]);
            minRooms = Math.max(minRooms, heap.size());
        }
        return minRooms;
    }
}
