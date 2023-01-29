package me.decentos.leetcode.design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class H460LFUCache {
    private final Map<Integer, Pair> cache;
    private final Map<Integer, LinkedHashSet<Integer>> frequencies;
    private final int capacity;
    private int minFreq;

    public H460LFUCache(int capacity) {
        this.cache = new HashMap<>();
        this.frequencies = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        Pair pair = cache.get(key);
        if (pair == null) return -1;

        int currFreq = pair.freq;
        Set<Integer> keys = frequencies.get(currFreq);
        keys.remove(key);
        if (minFreq == currFreq && keys.isEmpty()) minFreq++;

        insert(key, currFreq + 1, pair.value);
        return pair.value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;

        Pair pair = cache.get(key);
        if (pair != null) {
            cache.put(key, new Pair(pair.freq, value));
            get(key);
            return;
        } else if (cache.size() == capacity) {
            Set<Integer> keys = frequencies.get(minFreq);
            int firstKey = keys.iterator().next();
            keys.remove(firstKey);
            cache.remove(firstKey);
        }
        minFreq = 1;
        insert(key, 1, value);
    }

    private void insert(int key, int freq, int value) {
        cache.put(key, new Pair(freq, value));
        frequencies.computeIfAbsent(freq, val -> new LinkedHashSet<>()).add(key);
    }

    private static class Pair {
        int freq;
        int value;

        public Pair(int freq, int value) {
            this.freq = freq;
            this.value = value;
        }
    }
}
