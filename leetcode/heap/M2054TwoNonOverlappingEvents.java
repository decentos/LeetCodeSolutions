package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class M2054TwoNonOverlappingEvents {

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        Queue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int maxValue = 0, maxSum = 0;

        for (int[] event : events) {
            while (!heap.isEmpty() && heap.peek()[1] < event[0]) {
                maxValue = Math.max(maxValue, heap.poll()[2]);
            }

            maxSum = Math.max(maxSum, maxValue + event[2]);
            heap.offer(event);
        }
        return maxSum;
    }
}
