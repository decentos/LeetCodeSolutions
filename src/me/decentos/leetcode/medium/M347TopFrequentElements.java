package me.decentos.leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class M347TopFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.merge(i, 1, Integer::sum);
        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (int curr : map.keySet()) {
            if (heap.size() < k) {
                heap.offer(curr);
            } else if (map.get(curr) > map.get(heap.peek())) {
                heap.poll();
                heap.offer(curr);
            }
        }

        int idx = 0;
        int[] answer = new int[k];
        while (!heap.isEmpty()) {
            answer[idx++] = heap.poll();
        }
        return answer;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        List<Integer>[] buckets = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.merge(i, 1, Integer::sum);

        for (int curr : map.keySet()) {
            int count = map.get(curr);
            if (buckets[count] == null) buckets[count] = new ArrayList<>();
            buckets[count].add(curr);
        }

        int idx = 0;
        int[] answer = new int[k];
        for (int i = buckets.length - 1; i >= 0; i--) {
            List<Integer> bucket = buckets[i];
            if (bucket == null) continue;

            for (int element : bucket) {
                answer[idx++] = element;
                if (idx == k) return answer;
            }
        }
        return answer;
    }
}
