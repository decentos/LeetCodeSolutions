package me.decentos.leetcode.design;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class E706DesignHashMap {
    private final Bucket[] buckets;
    private final int range;

    public E706DesignHashMap() {
        range = 777;
        buckets = new Bucket[range];
        Arrays.fill(buckets, new Bucket());
    }

    public void put(int key, int value) {
        int index = hash(key);
        buckets[index].insert(key, value);
    }

    public int get(int key) {
        int index = hash(key);
        return buckets[index].get(key);
    }

    public void remove(int key) {
        int index = hash(key);
        buckets[index].delete(key);
    }

    private int hash(int key) {
        return key % range;
    }

    private static class Bucket {
        private final List<Pair> bucket;

        public Bucket() {
            bucket = new LinkedList<>();
        }

        public void insert(Integer key, Integer value) {
            delete(key);
            bucket.add(new Pair(key, value));
        }

        public void delete(Integer key) {
            bucket.stream().filter(it -> it.key == key).findFirst().ifPresent(bucket::remove);
        }

        public int get(Integer key) {
            Pair pair = bucket.stream().filter(it -> it.key == key).findFirst().orElse(null);
            return pair != null ? pair.value : -1;
        }
    }

    private static class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
