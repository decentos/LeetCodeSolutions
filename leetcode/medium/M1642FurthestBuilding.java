package medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class M1642FurthestBuilding {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff <= 0) continue;

            heap.offer(diff);
            if (ladders >= heap.size()) continue;

            bricks -= heap.poll();
            if (bricks < 0) return i;
        }
        return heights.length - 1;
    }

    public int furthestBuilding2(int[] heights, int bricks, int ladders) {
        Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff <= 0) continue;

            heap.offer(diff);
            bricks -= diff;
            if (bricks < 0 && ladders == 0) return i;

            if (bricks < 0) {
                bricks += heap.poll();
                ladders--;
            }
        }
        return heights.length - 1;
    }
}
