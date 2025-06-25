package uber.algo;

import java.util.*;

public class M621TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int intervals = 0;
        Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int[] counter = new int[26];

        for (char task : tasks) {
            counter[task - 'A']++;
        }

        for (int c : counter) {
            if (c > 0) {
                heap.offer(c);
            }
        }

        while (!heap.isEmpty()) {
            int circle = n + 1;
            int taskCount = 0;
            List<Integer> remains = new ArrayList<>();

            while (!heap.isEmpty() && circle > 0) {
                int curr = heap.poll();
                if (curr > 1) {
                    remains.add(curr - 1);
                }

                taskCount++;
                circle--;
            }

            remains.forEach(heap::offer);
            intervals += heap.isEmpty() ? taskCount : n + 1;
        }
        return intervals;
    }
}
