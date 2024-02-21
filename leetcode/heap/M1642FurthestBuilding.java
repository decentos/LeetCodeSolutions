package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class M1642FurthestBuilding {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        Queue<Integer> heap = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for (int i = 0; i < n - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff <= 0) {
                continue;
            }

            if (bricks >= diff) {
                bricks -= diff;
                heap.offer(diff);
            } else if (ladders > 0) {
                ladders--;
                if (!heap.isEmpty() && heap.peek() > diff) {
                    bricks += heap.poll() - diff;
                    heap.offer(diff);
                }
            } else {
                return i;
            }
        }
        return n - 1;
    }
}
