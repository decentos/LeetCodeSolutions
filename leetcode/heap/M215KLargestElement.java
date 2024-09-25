package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class M215KLargestElement {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            if (heap.size() < k) {
                heap.offer(num);
            } else if (num > heap.peek()) {
                heap.poll();
                heap.offer(num);
            }
        }
        return heap.peek();
    }
}
