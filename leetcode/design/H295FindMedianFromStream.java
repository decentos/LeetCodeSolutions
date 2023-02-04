package design;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class H295FindMedianFromStream {
    private final Queue<Integer> minHeap;
    private final Queue<Integer> maxHeap;

    public H295FindMedianFromStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() > num) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        balance();
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) return (double) maxHeap.peek();
        else if (minHeap.size() > maxHeap.size()) return (double) minHeap.peek();
        else return (double) (maxHeap.peek() + minHeap.peek()) / 2;
    }

    private void balance() {
        while (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        }
        while (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }
}
