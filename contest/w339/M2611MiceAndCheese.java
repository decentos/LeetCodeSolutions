package w339;

import java.util.PriorityQueue;
import java.util.Queue;

public class M2611MiceAndCheese {

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int sum = 0;
        for (int i : reward2) sum += i;
        if (k == 0) return sum;

        Queue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int diff = reward1[i] - reward2[i];
            if (heap.size() < k) {
                heap.offer(diff);
            } else if (diff > heap.peek()) {
                heap.poll();
                heap.offer(diff);
            }
        }
        while (!heap.isEmpty()) sum += heap.poll();
        return sum;
    }
}
