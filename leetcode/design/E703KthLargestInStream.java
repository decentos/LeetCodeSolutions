package design;

import java.util.PriorityQueue;
import java.util.Queue;

public class E703KthLargestInStream {
    private final Queue<Integer> heap;
    private final int maxSize;

    public E703KthLargestInStream(int k, int[] nums) {
        heap = new PriorityQueue<>();
        maxSize = k;
        for (int i : nums) {
            checkAndAdd(i);
        }
    }

    public int add(int val) {
        return checkAndAdd(val);
    }

    private int checkAndAdd(int val) {
        if (heap.size() < maxSize) {
            heap.offer(val);
        } else if (heap.peek() < val) {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }
}
