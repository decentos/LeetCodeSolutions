package design;

import java.util.PriorityQueue;
import java.util.Queue;

public class M2336SmallestNumber {
    private final Queue<Integer> heap;
    private int min;

    public M2336SmallestNumber() {
        heap = new PriorityQueue<>();
        min = 1;
    }

    public int popSmallest() {
        if (!heap.isEmpty()) {
            return heap.poll();
        }
        min++;
        return min - 1;
    }

    public void addBack(int num) {
        if (min > num && !heap.contains(num)) {
            heap.offer(num);
        }
    }
}
