package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class M1167MinimumCost {

    public int connectSticks(int[] sticks) {
        if (sticks.length < 2) return 0;
        int sum = 0;
        Queue<Integer> heap = new PriorityQueue<>();
        for (int s : sticks) heap.offer(s);

        while (heap.size() > 1) {
            int s1 = heap.poll(), s2 = heap.poll();
            int currSum = s1 + s2;
            sum += currSum;
            heap.offer(currSum);
        }
        return sum;
    }
}
