package matrix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class M253MeetingRooms2 {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Queue<Integer> heap = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!heap.isEmpty() && interval[0] >= heap.peek()) {
                heap.poll();
            }
            heap.offer(interval[1]);
        }
        return heap.size();
    }
}
