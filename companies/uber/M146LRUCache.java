package uber;

import java.util.LinkedHashMap;
import java.util.Map;

public class M146LRUCache {

    private static class LRUCache {
        private final Map<Integer, Integer> cache;
        private final int capacity;

        public LRUCache(int capacity) {
            this.cache = new LinkedHashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                int value = cache.get(key);
                cache.remove(key);
                cache.put(key, value);
                return value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                cache.remove(key);
            } else if (cache.size() == capacity) {
                int oldest = cache.keySet().iterator().next();
                cache.remove(oldest);
            }
            cache.put(key, value);
        }
    }

    private static class LRUCache2 extends LinkedHashMap<Integer, Integer> {
        private final int capacity;

        public LRUCache2(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}
