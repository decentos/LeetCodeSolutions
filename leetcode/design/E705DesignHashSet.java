package design;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class E705DesignHashSet {
    private final Bucket[] buckets;
    private final int range;

    public E705DesignHashSet() {
        range = 777;
        buckets = new Bucket[range];
        Arrays.fill(buckets, new Bucket());
    }

    public void add(int key) {
        int index = hash(key);
        buckets[index].insert(key);
    }

    public void remove(int key) {
        int index = hash(key);
        buckets[index].delete(key);
    }

    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index].exist(key);
    }

    private int hash(int key) {
        return key % range;
    }

    private static class Bucket {
        private final List<Integer> bucket;

        public Bucket() {
            bucket = new LinkedList<>();
        }

        public void insert(Integer key) {
            if (!bucket.contains(key))  {
                bucket.add(key);
            }
        }

        public void delete(Integer key) {
            bucket.remove(key);
        }

        public boolean exist(Integer key) {
            return bucket.contains(key);
        }
    }
}
