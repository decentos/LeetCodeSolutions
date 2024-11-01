package uber;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class M362DesignHitCounter {

    private static class HitCounter {
        private final Deque<Integer> hits;

        public HitCounter() {
            hits = new ArrayDeque<>();
        }

        public void hit(int timestamp) {
            hits.offer(timestamp);
        }

        public int getHits(int timestamp) {
            while (!hits.isEmpty() && hits.peek() <= timestamp - 300) {
                hits.poll();
            }
            return hits.size();
        }
    }

    private static class HitCounter2 {
        private final Deque<Integer> hits;
        private final Map<Integer, Integer> freq;
        private int count;

        public HitCounter2() {
            hits = new ArrayDeque<>();
            freq = new HashMap<>();
            count = 0;
        }

        public void hit(int timestamp) {
            if (!freq.containsKey(timestamp)) {
                hits.offer(timestamp);
                freq.put(timestamp, 1);
            } else {
                freq.merge(timestamp, 1, Integer::sum);
            }
            count++;
        }

        public int getHits(int timestamp) {
            while (!hits.isEmpty() && hits.peek() <= timestamp - 300) {
                int removed = hits.poll();
                count -= freq.get(removed);
                freq.remove(removed);
            }
            return count;
        }
    }
}
