package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class E1046LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : stones) heap.offer(i);

        while (!heap.isEmpty()) {
            int heaviest1 = heap.poll();
            if (!heap.isEmpty()) {
                int heaviest2 = heap.poll();
                if (heaviest1 != heaviest2) {
                    heap.offer(heaviest1 - heaviest2);
                }
            } else {
                return heaviest1;
            }
        }
        return 0;
    }
}
