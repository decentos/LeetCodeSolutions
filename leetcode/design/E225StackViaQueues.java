package design;

import java.util.LinkedList;
import java.util.Queue;

public class E225StackViaQueues {
    private final Queue<Integer> queue;

    public E225StackViaQueues() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
        int size = queue.size();
        while (size > 1) {
            int curr = queue.poll();
            queue.offer(curr);
            size--;
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
