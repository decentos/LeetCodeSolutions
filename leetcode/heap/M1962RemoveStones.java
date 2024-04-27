package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class M1962RemoveStones {

    public int minStoneSum(int[] piles, int k) {
        Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : piles) heap.offer(i);

        while (!heap.isEmpty() && k > 0) {
            int max = heap.poll();
            int floor = max / 2;
            heap.offer(max - floor);
            k--;
        }
        return heap.stream().reduce(Integer::sum).orElse(0);
    }
}
