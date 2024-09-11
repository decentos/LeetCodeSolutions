package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class E933NumberRecentCalls {
    private final Deque<Integer> requests;

    public E933NumberRecentCalls() {
        requests = new ArrayDeque<>();
    }

    public int ping(int t) {
        while (!requests.isEmpty() && t - 3000 > requests.peek()) {
            requests.poll();
        }
        requests.offer(t);
        return requests.size();
    }
}
