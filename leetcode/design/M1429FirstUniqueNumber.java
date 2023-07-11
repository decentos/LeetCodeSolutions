package design;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class M1429FirstUniqueNumber {
    private final Queue<Integer> queue;
    private final Map<Integer, Boolean> unique;

    public M1429FirstUniqueNumber(int[] nums) {
        queue = new ArrayDeque<>();
        unique = new HashMap<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        while (!queue.isEmpty() && !unique.get(queue.peek())) queue.poll();
        return queue.isEmpty() ? -1 : queue.peek();
    }

    public void add(int value) {
        if (unique.containsKey(value) && unique.get(value)) {
            unique.replace(value, false);
        } else if (!unique.containsKey(value)) {
            unique.put(value, true);
            queue.offer(value);
        }
    }
}
