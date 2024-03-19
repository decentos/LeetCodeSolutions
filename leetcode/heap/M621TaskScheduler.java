package heap;

import java.util.*;

public class M621TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }

        Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int c : count) {
            if (c > 0) {
                heap.offer(c);
            }
        }

        int time = 0;
        while (!heap.isEmpty()) {
            int circle = n + 1;
            int taskCount = 0;
            List<Integer> store = new ArrayList<>();

            while (circle > 0 && !heap.isEmpty()) {
                int curr = heap.poll();
                if (curr > 1) {
                    store.add(curr - 1);
                }
                taskCount++;
                circle--;
            }
            store.forEach(heap::offer);
            time += heap.isEmpty() ? taskCount : n + 1;
        }
        return time;
    }
}
