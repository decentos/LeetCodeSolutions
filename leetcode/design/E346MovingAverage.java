package design;

import java.util.LinkedList;
import java.util.Queue;

public class E346MovingAverage {
    private final int size;
    private final Queue<Integer> queue;
    private int sum;

    public E346MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<>();
        sum = 0;
    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.poll();
        }
        sum += val;
        queue.offer(val);
        return (double) sum / queue.size();
    }
}
