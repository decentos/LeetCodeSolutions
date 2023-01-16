package me.decentos.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class M692TopKFrequent {

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        AtomicInteger atomK = new AtomicInteger(k);

        Map<String, Integer> map = new TreeMap<>();
        for (String s : words) {
            map.merge(s, 1, Integer::sum);
        }
        map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(it -> {
                    if (atomK.get() > 0) {
                        result.add(it.getKey());
                        atomK.getAndDecrement();
                    }
                });
        return result;
    }

    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new TreeMap<>();
        for (String s : words) {
            map.merge(s, 1, Integer::sum);
        }
        return map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
    }
}
