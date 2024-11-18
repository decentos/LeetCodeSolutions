package uber.design;

import java.util.HashMap;
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

    private static class LRUCache3 {
        private final Map<Integer, Node> keyToNode;
        private final int capacity;
        private final Node head;
        private final Node tail;

        public LRUCache3(int capacity) {
            this.keyToNode = new HashMap<>();
            this.capacity = capacity;
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        public int get(int key) {
            if (keyToNode.containsKey(key)) {
                Node curr = keyToNode.get(key);
                removeNode(curr);
                addNode(curr.key, curr.value);
                return curr.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (keyToNode.containsKey(key)) {
                Node curr = keyToNode.get(key);
                removeNode(curr);
            } else if (keyToNode.size() == capacity) {
                Node removed = head.next;
                keyToNode.remove(removed.key);
                removeNode(removed);
            }
            addNode(key, value);
        }

        private void addNode(int key, int value) {
            Node prev = tail.prev;
            Node curr = new Node(key, value);
            keyToNode.put(key, curr);

            prev.next = curr;
            curr.next = tail;

            curr.prev = prev;
            tail.prev = curr;
        }

        private void removeNode(Node curr) {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }

        private static class Node {
            int key;
            int value;
            Node prev;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
